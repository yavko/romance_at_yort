package utils;
import javax.swing.*;
import java.awt.*;



/**
 * Sort of a mix between a JLabel and a JTextArea
 *
 * @author Yavko
 * @version 0.1.0
 */
public class WrappedTextBg extends WrappedText {
    /**
     * Constructor for objects of class WrappedTextBg
     */
    private Image bgImg;
    public WrappedTextBg(String text, Image bgImg) {
        super(text);
        this.bgImg = bgImg;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bgImg, 0, 0, getWidth(), getHeight(), this);
        super.paintComponent(g);
    }
}
