package engine;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GameCanvas extends JPanel {
    /**
     * Constructor for objects of class GameCanvas
     */
    /*public GameCanvas(Image bgImg, Character[] characters) {
        this.characters = new HashSet<>(Arrays.asList(characters));
        this.currentBgImg = bgImg;
    }*/
    public GameCanvas() {
        this.characters = new HashSet<>();
    }
    private Image currentBgImg;
    private HashSet<Character> characters;
    
    public Image getBgImg() {
        return currentBgImg;
    }
    public void setBgImg(Image newImg) {
        currentBgImg = newImg;
    }
    public void setCharacters(final HashSet<Character> characters) {
        this.characters = characters;
    }
    public HashSet<Character> getCharacters() {
        return characters;
    }
    public boolean addCharacter(Character chr) {
        return characters.add(chr);
    }
    public Character getCharacter(Class chrClass) {
        for (Character chr: characters) {
            if (chrClass.isInstance(chr)) {
                return chr;
            }
        }
        return null;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        if (currentBgImg != null)
            g.drawImage(currentBgImg, 0, 0, getWidth(), getHeight(), this);
        for (Character chr: characters) {
            Image img = chr.getCurrentImg();
            if (img != null) {
                int imgHeight = img.getHeight(this);
                int imgWidth = img.getWidth(this);
                int canvasHeight = getHeight();
                int canvasWidth = getWidth();
                double ratio = canvasHeight/(imgHeight*1.0);
                
                g.drawImage(
                    img,
                    (int)((chr.getXPos()/100.0)*(canvasWidth-imgWidth*ratio)),
                    (int)((chr.getYPos()/100.0)*(canvasHeight)),
                    (int)(imgWidth*ratio),
                    canvasHeight,
                    this
                );
            } else {
                System.out.println("meow:" + chr.getName());
            }
        }
    }
    
}
