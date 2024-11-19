import javax.swing.*;
import java.awt.Graphics;

public class ContentWrapper extends JPanel {
    private JPanel content;
    /**
     * Constructor for objects of class ContentWrapper
     */
    public ContentWrapper(JPanel content) {
        this.content = content;
        add(content);
        revalidate();
        repaint(); // sometimes needed
    }
    public void swapContent(JPanel newContent) {
        remove(content);
        this.content = newContent;
        add(content);
        revalidate();
        repaint(); // sometimes needed
    }
}
