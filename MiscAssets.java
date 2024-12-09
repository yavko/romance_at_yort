import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.File;

public class MiscAssets {
    public static HashMap<String, BufferedImage> backgrounds = new HashMap<>();
    private static ImageReader reader = ImageIO.getImageReadersByFormatName("png").next();
    private static void addImage(HashMap<String, BufferedImage> map, String fileName, String name) {
        URL imgUrl = MiscAssets.class.getResource(fileName);
        try {
            reader.setInput(ImageIO.createImageInputStream(new File(fileName)), true);
            BufferedImage img = reader.read(0, reader.getDefaultReadParam());
            map.put(name, img);
        } catch (IOException _ex) {
            System.out.println("failed to load asset " + name + " which should be located at: " + fileName);   
        }
    }
    static {
        ImageIO.setUseCache(false);

        addImage(backgrounds, "assets/opening_scene.png", "main");

        addImage(backgrounds, "assets/bgPt1.png", "base");

        addImage(backgrounds, "assets/bedroom.png", "bedroom");

        addImage(backgrounds, "assets/ChooseDifficulty.png", "introDiff");

        addImage(backgrounds, "assets/directions.png", "directions");

        addImage(backgrounds, "assets/bgPt2.png", "bgPt2");

        addImage(backgrounds, "assets/welcome.png", "welcome");

        addImage(backgrounds, "assets/specialScene1.png", "ss1");

        addImage(backgrounds, "assets/dancepartner.png", "dancePartner");

        addImage(backgrounds, "assets/outfitsituation.png", "outfitSit");

        addImage(backgrounds, "assets/dancesituation.png", "danceSit");

        addImage(backgrounds, "assets/dance.png", "dance");

        addImage(backgrounds, "assets/tttsituation.png", "tttSit");

        addImage(backgrounds, "assets/tictactoe.png", "ticTacToe");

        addImage(backgrounds, "assets/brrrwaysituation.png", "brrrwaySit");

        addImage(backgrounds, "assets/brrrwaymeeting.png", "brrrwayMeeting");

        addImage(backgrounds, "assets/choicebg.png", "choicebg");

        addImage(backgrounds, "assets/hallwaybg.png", "hallwaybg");

        addImage(backgrounds, "assets/graduation.png", "graduation");

        addImage(backgrounds, "assets/gradsituation.png", "gradSit");

        addImage(backgrounds, "assets/endscene.png", "endScene");

        addImage(backgrounds, "assets/marriagesituation.png", "marriageSit");

        addImage(backgrounds, "assets/tttbg.png", "tttbg");

        addImage(backgrounds, "assets/greendressbg.png", "greendressbg");

        addImage(backgrounds, "assets/suitbg.png", "suitbg");

        addImage(backgrounds, "assets/schooluniformbg.png", "schooluniformbg");

        addImage(backgrounds, "assets/balconybg.png", "balconybg");

        addImage(backgrounds, "assets/dancebg.png", "dancebg");

        addImage(backgrounds, "assets/graduationbg.png", "graduationbg");

        addImage(backgrounds, "assets/churchbg.png", "churchbg");

        addImage(backgrounds, "assets/freedombg.png", "freedombg");

        addImage(backgrounds, "assets/ripbg.png", "ripbg");

        addImage(backgrounds, "assets/theend.png", "endbg");

        addImage(backgrounds, "assets/credits.png", "credits");

        addImage(backgrounds, "assets/textboxbg.png", "textboxbg");

        addImage(backgrounds, "assets/cafe.png", "cafebg");

        addImage(backgrounds, "assets/awkward.png", "awkward");

        addImage(backgrounds, "assets/awkwardSit.png", "awkwardSit");

        addImage(backgrounds, "assets/outsideschoolbg.png", "schoolbg");
        
        addImage(backgrounds, "assets/5thgradecrush.png", "crush");
        
        addImage(backgrounds, "assets/5thgradecrushSit.png", "crushSit");
        
        addImage(backgrounds, "assets/BADover.png", "BADover");
        
        addImage(backgrounds, "assets/sadover.png", "badOver");
        
        addImage(backgrounds, "assets/desk.png", "desk");
        
        addImage(backgrounds, "assets/left.png", "left");
        
        addImage(backgrounds, "assets/right.png", "right");
        
        addImage(backgrounds, "assets/up.png", "up");
        
        addImage(backgrounds, "assets/down.png", "down");
        
        addImage(backgrounds, "assets/choice2.png", "c2");
        
        addImage(backgrounds, "assets/choice3.png", "c3");

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

    public static String generateConfession(String name){
        try {
            return Files.readString(
                Paths.get("assets/confession.txt")
            ).replace("[name]", name);
        } catch (IOException ioe)
        {
            System.out.println("failed to load directions txt file");
            return "bruh";
        }
    }

    public static String generateRIPText(String name){
        try {
            return Files.readString(
                Paths.get("assets/rip.txt")
            ).replace("[name]", name);
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
    public MiscAssets() {}
}
