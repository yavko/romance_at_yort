import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Paths;


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
    public static String generateBackgroundInfo(String name){
        try {
            return Files.readString(
            Paths.get("assets/backgroundInfo.txt")
        ).replace("[name]", name);
        } catch (IOException ioe)
        {
            System.out.println("failed to load bg info txt file");
            return "bruh";
        }
    }
    public static String generateBackgroundInfo2(String name){
        try {
            return Files.readString(
                Paths.get("assets/backgroundInfo2.txt")
            ).replace("[name]", name);
        } catch (IOException ioe)
        {
            System.out.println("failed to load bg info 2 txt file");
            return "bruh";
        }
    }
    public static String generateDirections(){
        try {
            return Files.readString(
                Paths.get("assets/directions.txt"));
        } catch (IOException ioe)
        {
            System.out.println("failed to load directions txt file");
            return "bruh";
        }
    }
    public static String generateWelcomeText(String name){
        return "Welcome " + name + " to Romance at Yort! We hope you enjoy!";
    }
    /**
     * Constructor for objects of class MiscAssets
     */
    public MiscAssets() {
        
    }
}
