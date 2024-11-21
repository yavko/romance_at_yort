import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.awt.Image;

public class BoJiden extends engine.Character {
    public static final String name = "Bo Jiden";
    public static final String backgroundInfo = "to be written";
    public static int age = 45;
    public BoJiden() {}
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
