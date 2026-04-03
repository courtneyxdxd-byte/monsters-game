import java.util.Random;

public class Person {
    int x, y; // координаты персонажа
    String image = "\uD83E\uDDD9\u200D"; // вид персонажа на поле
    int live = 3; // количество жизней


    Person(int size) {
        Random r = new Random();
        y = size;
        int n = r.nextInt(size);
        x = n == 0 ? 1 : n;
    }
    void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isMoveCorrect(int x, int y) {
        return this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }
    public void downLive() {
        if (live < 0)
            live = 0;
        else
            live--;
    }
}

