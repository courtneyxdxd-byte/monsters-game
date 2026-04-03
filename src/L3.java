import java.util.Scanner;

public class L3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ответ:");
        // int x = sc.nextInt();
        String answer = sc.nextLine();
        //        boolean condition = x < 0 || x > 10;
        boolean condition = answer.equals( "ДА");
        if (condition) {
            System.out.println("Вы меня увидите, если condition = TRUE");
        } else {
            if (answer.equals("НЕТ")) {
                System.out.println("ВЫ ВВЕЛИ \"НЕТ\"");
            } else {
                System.out.println("Вы ввели что-то непонятное");
            }
        }
        System.out.println("Меня вы видите ВСЕГДА");
    }
}
