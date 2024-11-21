import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Oswaldo extends engine.Character {
    public static final String name = "Oswaldo";
    public static final String backgroundInfo = "to be written";
    public static int age = 18;
    public Oswaldo(int x, int y) { super(x,y); }
    public void displayEmotion(engine.Game game, engine.Emotion emote) {}
    public int getAge() { return age; }
    public void setAge(int newAge) { age = newAge; }
    public String getName() { return name; }
    public String getBackgroundInfo() { return backgroundInfo; }
    public Image getCurrentImg() {
        URL imgUrl = MiscAssets.class.getResource("assets/Oswaldo.png");
        try {
            BufferedImage img = ImageIO.read(imgUrl);
            return img;
        } catch (IOException _ex) {
            System.out.println("failed to load oswaldo asset");
            return null;
        }
    }
}
