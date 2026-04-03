public class Jumper {
    int height;

    public void jump() {
        height += 2;
     }
    public void bigJump() {
        height += 100;
    }
    public static double sqr(double x) {
        return x * x;
    }

    public static void main(String[] args) {
        Jumper jumper = new Jumper();
        jumper.height = 0;
        jumper.jump();
        System.out.println(jumper.height);
    }
}
