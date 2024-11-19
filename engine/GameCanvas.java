package engine;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GameCanvas extends JPanel {
    /**
     * Constructor for objects of class GameCanvas
     */
    public GameCanvas(Image bgImg, Character[] characters) {
        this.characters = new HashSet<>(Arrays.asList(characters));
        this.currentBgImg = bgImg;
    }
    private Image currentBgImg;
    private HashSet<Character> characters;
    
    public Image getBgImg() {
        return currentBgImg;
    }
    public void setBgImg(Image newImg) {
        currentBgImg = newImg;
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
        g.drawImage(currentBgImg, 0, 0, getWidth(), getHeight(), this);
        for (Character chr: characters) {
            g.drawImage(chr.getCurrentImg(), chr.getXPos(), chr.getYPos(), this);
        }
    }
    
}
