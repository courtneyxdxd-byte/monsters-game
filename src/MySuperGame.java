
public class MySuperGame {
    MyScreen screen;
    public void setScreen(MyScreen screen) {
        this.screen = screen;
    }

    public void renderScreen() {
        screen.create();
        while (true) {
            screen.render();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}