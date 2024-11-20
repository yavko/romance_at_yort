import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;


public class MiscAssets {
    
    public static HashMap<String, BufferedImage> backgrounds = new HashMap<>();
    private static void addImage(HashMap<String, BufferedImage> map, String fileName, String name) {
        URL imgUrl = MiscAssets.class.getResource(fileName);
        try {
            BufferedImage img = ImageIO.read(imgUrl);
            map.put(name, img);
        } catch (IOException _ex) {
            System.out.println("failed to load asset " + name + " which should be located at: " + fileName);   
        }
    }
    static {
        addImage(backgrounds, "assets/opening_scene.png", "main");
        
        addImage(backgrounds, "assets/bg.png", "base");
        
        addImage(backgrounds, "assets/bedroom.png", "bedroom");
        
    }
    /**
     * Constructor for objects of class MiscAssets
     */
    public MiscAssets() {
        
    }
}
