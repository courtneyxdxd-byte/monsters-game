import java.util.Random;
import java.util.Scanner;

public class SchoolMonster extends Monster {
    private String image = "U+1F9DB";
    private final int x;
    private final int y;
    Random r = new Random();
    SchoolMonster(int sizeBoard) {
        super(sizeBoard);
        this.y = this.r.nextInt(sizeBoard + 1);
        this.x = this.r.nextInt(sizeBoard);
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean taskMonster(int difficultGame) {
        System.out.println("Complete the obstacle course by solving a math problem:");
        int x = this.r.nextInt(200);
        int y = this.r.nextInt(50);
        int trueAnswer = x + y;
        System.out.println("Solve this example to get a life: " + x + " - " + y + " = ?");
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        if (trueAnswer == ans) {
            System.out.println("Well done, you beat him down!");
            return true;
        } else {
            System.out.println("Oh, you're hurt");
            return false;
        }
    }
    }
