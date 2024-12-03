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
        
        addImage(backgrounds, "assets/hangout.png", "hangout");
        
        addImage(backgrounds, "assets/schooluniform.png", "schoolUniform");
        
        addImage(backgrounds, "assets/dancepartner.png", "dancePartner");
        
        addImage(backgrounds, "assets/greendress.png", "greenDress");
        
        addImage(backgrounds, "assets/outfitsituation.png", "outfitSit");
        
        addImage(backgrounds, "assets/dancesituation.png", "danceSit");
        
        addImage(backgrounds, "assets/dance.png", "dance");
        
        addImage(backgrounds, "assets/cojogclassroom.png", "coJogClass");
        
        addImage(backgrounds, "assets/tttwinorlose.png", "winOrLose");
        
        addImage(backgrounds, "assets/tttsituation.png", "tttSit");
        
        addImage(backgrounds, "assets/tictactoe.png", "ticTacToe");
        
        addImage(backgrounds, "assets/brrrwaysituation.png", "brrrwaySit");
        
        addImage(backgrounds, "assets/brrrwaymeeting.png", "brrrwayMeeting");
        
        addImage(backgrounds, "assets/choicebg.png", "choicebg");
        
        addImage(backgrounds, "assets/brrrwaygood.png", "brrrwayGood");
        
        addImage(backgrounds, "assets/brrrwayrude.png", "brrrwayRude");
        
        addImage(backgrounds, "assets/brrrwayhair.png", "brrrwaymysterious");
        
        addImage(backgrounds, "assets/desYORTaura.png", "winttt");
        
        addImage(backgrounds, "assets/tttloss.png", "losettt");
        
        addImage(backgrounds, "assets/hwstudy.png", "hwStudy");
        
        addImage(backgrounds, "assets/nottt.png", "rejectTTT");
        
        addImage(backgrounds, "assets/yesdance.png", "yesDance");
        
        addImage(backgrounds, "assets/buffetsnacking.png", "buffetSnacking");
        
        addImage(backgrounds, "assets/ditchedoswaldo.png", "ditchOswaldo");
        
        addImage(backgrounds, "assets/rejecthangout.png", "rejectHangout");
        
        addImage(backgrounds, "assets/graduation.png", "graduation");
        
        addImage(backgrounds, "assets/gradsituation.png", "gradSit");
        
        addImage(backgrounds, "assets/gradfriendzone.png", "gradFriendZone");
        
        addImage(backgrounds, "assets/nogradbye.png", "noGradBye");
        
        addImage(backgrounds, "assets/endscene.png", "endScene");
        
        addImage(backgrounds, "assets/marriagesituation.png", "marriageSit");
        
        addImage(backgrounds, "assets/happyending.png", "HappyEnding");
        
        addImage(backgrounds, "assets/nowedding.png", "rejectProposal");
        
        addImage(backgrounds, "assets/brrrwayc1.png", "brrrwayc1");
        
        addImage(backgrounds, "assets/brrrwayc2.png", "brrrwayc2");
        
        addImage(backgrounds, "assets/brrrwayc3.png", "brrrwayc3");
        
        addImage(backgrounds, "assets/tttc1.png", "tttc1");
        
        addImage(backgrounds, "assets/tttc2.png", "tttc2");
        
        addImage(backgrounds, "assets/dancec1.png", "yes");
        
        addImage(backgrounds, "assets/dancec2.png", "dancec2");
        
        addImage(backgrounds, "assets/dancec3.png", "no");
        
        addImage(backgrounds, "assets/dressc1.png", "dressc1");
        
        addImage(backgrounds, "assets/dressc2.png", "dressc2");
        
        addImage(backgrounds, "assets/hangoutc1.png", "hangoutc1");
        
        addImage(backgrounds, "assets/hangoutc2.png", "hangoutc2");
        
        addImage(backgrounds, "assets/proposalc1.png", "proposalc1");
        
        addImage(backgrounds, "assets/proposalc2.png", "proposalc2");
        
        addImage(backgrounds, "assets/secondchancec1.png", "scc1");
        
        addImage(backgrounds, "assets/secondchancec2.png", "scc2");
        
        addImage(backgrounds, "assets/brrrwaybg.png", "brrrwaybg");
        
        addImage(backgrounds, "assets/tttbg.png", "tttbg");
        
        addImage(backgrounds, "assets/greendressbg.png", "greendressbg");
        
        addImage(backgrounds, "assets/suit.png", "suitbg");
        
        addImage(backgrounds, "assets/schooluniformbg.png", "schooluniformbg");
        
        addImage(backgrounds, "assets/balcony.png", "balconybg");
        
        addImage(backgrounds, "assets/dancebg.png", "dancebg");
        
        addImage(backgrounds, "assets/graduationbg.png", "graduationbg");
        
        addImage(backgrounds, "assets/churchbg.png", "churchbg");
        
        addImage(backgrounds, "assets/freedombg.png", "freedombg");
        
        addImage(backgrounds, "assets/ripbg.png", "ripbg");
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
    public MiscAssets() {}
}
