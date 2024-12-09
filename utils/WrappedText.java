package utils;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;



/**
 * Sort of a mix between a JLabel and a JTextArea
 *
 * @author Yavko
 * @version 0.1.0
 */
public class WrappedText extends JTextArea {
    /**
     * Constructor for objects of class WrappedText
     */
    public WrappedText(String text) {
        super(text);
        setStyles();
    }
    private int lineSpacing = 10;
    public WrappedText(String text, int lineSpacing) {
        super(text);
        setStyles();
        this.lineSpacing = lineSpacing;
    }
    private void setStyles() {
        setEditable(false);
        setLineWrap(true);
        setWrapStyleWord(true);
        setHighlighter(null);
        JLabel lb = new JLabel();
        Font f = lb.getFont();
        setFont(f.deriveFont(f.getSize2D() * 0.9f));
        setBorder(lb.getBorder());
        setBackground(new Color(lb.getBackground().getRGB(), true));
        setForeground(new Color(lb.getForeground().getRGB(), true));
        setOpaque(lb.isOpaque());
    }
    
}
