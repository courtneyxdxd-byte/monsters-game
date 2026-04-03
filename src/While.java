public class While {
    public static void main(String[] args)  throws InterruptedException {
        int x = 0;
        while (x < -10) {
            System.out.println(x++ + " больше -1");
            Thread.sleep(50);
            if (x > 10) break;
        }

        for (int i = 0; i < 15; i += 2) {
            System.out.println("I = " + i);
        }
        String[] array = new String[10];
        array[9] = "Mm";
        array[8] = "Mm";
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);

        }
    }
}
//if (board[y - 1][x - 1].equals("  ")) {
//    board[personY - 1][personX - 1] = "  ";
//    personX = x;
//    personY = y;
//    step++;
//    System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY +
//                                        "\\nХод номер: " + step);
//} else if (board[y - 1][x - 1].equals(castle)) {
//    System.out.println("Вы прошли игру!");
//    break;
//} else {
//    System.out.println("Решите задачу.");
//}
