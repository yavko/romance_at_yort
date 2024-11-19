import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;


public class MiscAssets {
    
    public static HashMap<String, BufferedImage> backgrounds = new HashMap<>();
    
    static {
        URL bgImgUrl = MiscAssets.class.getResource("assets/opening_scene.png");
        try {
            BufferedImage img = ImageIO.read(bgImgUrl);
            backgrounds.put("main", img);
        } catch (IOException _ex) { System.out.println("failed to load asset"); }
        
        URL baseBgUrl = MiscAssets.class.getResource("assets/bg.png");
        try {
            BufferedImage img = ImageIO.read(baseBgUrl);
            backgrounds.put("base", img);
        } catch (IOException _ex) { System.out.println("failed to load asset"); }
        
        URL bedroomImgUrl = MiscAssets.class.getResource("assets/bedroom.png");
        try {
            BufferedImage img = ImageIO.read(bedroomImgUrl);
            backgrounds.put("bedroom", img);
        } catch (IOException _ex) { System.out.println("failed to load asset"); }
    }
    /**
     * Constructor for objects of class MiscAssets
     */
    public MiscAssets() {
    
    }
}
