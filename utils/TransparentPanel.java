package utils;
import javax.swing.*;
import java.awt.*;

public class TransparentPanel extends JPanel {
    public TransparentPanel(LayoutManager layout) {
        super(layout);
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
    }
    public TransparentPanel() {
        super();
        setBackground(new Color(0,0,0,0));
        setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        Rectangle r = g.getClipBounds();
        g.fillRect(r.x, r.y, r.width, r.height);
        super.paintComponent(g);
    }
}