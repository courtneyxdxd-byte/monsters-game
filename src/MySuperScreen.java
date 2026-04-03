
public class MySuperScreen
        implements MyScreen{
    @Override
    public void create() {
        System.out.println("Load sprites");
    }
    @Override
    public void render() {
        System.out.println("Render sprites");
    }
}
