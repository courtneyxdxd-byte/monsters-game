import java.util.Random;
import java.util.Scanner;


public class Game {
    public static void main(String[] args) {
        int step = 0;

        int sizeBoard = 5;

        step = step + 1;
        Person person = new Person(sizeBoard);

        String castle = "\uD83C\uDFF0";
        int castleY = 1;
        Random random = new Random();
        int castleX = 1 + random.nextInt(sizeBoard);
        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";

        String begin = "|    | |";
        String end = " |    |";
        Scanner sc = new Scanner(System.in);

        System.out.println("Hi! Are you ready to start playing the game? (Write: YES or NO)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.println("Ваш ответ:\t" + answer);
        if (answer.equals("YES")) {

            System.out.println("Выбери сложность игры(от 1 до 5):");
            int difficultGame = sc.nextInt();
            System.out.println("Выбранная сложность:\t" + difficultGame);
            System.out.println("Number of lives: " + person.getLive());
            String[][] board = new String[sizeBoard][sizeBoard];

            for (int y = 1; y <= sizeBoard; y++) {
                for (int x = 1; x <= sizeBoard; x++) {
                    board[(y - 1)][x - 1] = "  ";
                }
            }
            Monster[] arrMonsters = new Monster[20];
            for (int i = 0; i < arrMonsters.length; i++) {
                Monster test;
                if (random.nextBoolean()) {
                    test = new Monster(sizeBoard);
                } else {
                    test = new BigMonster(sizeBoard);
                }
                arrMonsters[i]= test;
                board[(test.getY() - 1)][test.getX() - 1] = test.getImage();
            }

            while ((person.getLive() > 0) && !(castleX == person.getX() && castleY == person.getY())) {
                // логика хода
                board[(castleY - 1)][castleX - 1] = castle;
                board[(person.getY() - 1)][person.getX() - 1] = person.getImage();
                for (int y = 1; y <= sizeBoard; y++) {
                    System.out.println(wall);
                    for (int x = 1; x <= sizeBoard; x++) {
                        System.out.print(leftBlock);
                        System.out.print(board[(y - 1)][x - 1]);
                    }
                    System.out.println(rightBlock);
                }
                System.out.println(wall);
                System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;");
                System.out.println("Координаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + "))");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (x != person.getX() && y != person.getY()) {
                    System.out.println("Неккоректный ход");
                } else if (Math.abs(x - person.getX()) == 1 || Math.abs(y - person.getY()) == 1) {
                    String next = board[y - 1][x - 1];
                    if (next.equals("  ")) {
                        person.setX(x);
                        person.setY(y);
                        step += 1;
                        System.out.println("Ход корректный; Новые координаты: " + person.getX() + ", " + person.getY() +
                                "\nХод номер: " + step);
                    } else if (next.equals(castle)) {
                        System.out.println("Вы прошли игру!");
                        break;
                    } else {
                        for (Monster monster : arrMonsters) {
                            if (monster.conflictPerson(x, y)) {
                                if (monster.taskMonster(difficultGame)) {
                                    board[person.getY() - 1][person.getX() - 1] = "  ";
                                    person.move(x, y);
                                } else {
                                    person.downLive();
                                }
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("Неккоректный ход");
                }
            }
        } else if (answer.equals("НЕТ")) {
            System.out.println("Ну ладно, приходи еще!");
        } else {
            System.out.println("Данные введены неккоректно");
        }


    }

    static void outputBoard(String[][] board, int live) {
        String leftBlock = "| ";
        String rightBlock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

        for (String[] raw : board) {
            System.out.println(wall);
            for (String col : raw) {
                System.out.print(leftBlock + col + " ");
            }
            System.out.println(rightBlock);
        }
        System.out.println(wall);


        System.out.println("Количество жизней:\t" + live + "\n");
    }
}
