package utils;
import javax.swing.*;
import java.awt.*;

public class TransparentPanel extends JPanel {
    public TransparentPanel(LayoutManager layout) {
        super(layout);
        setOpaque(false);
    }
    public TransparentPanel() {
        super();
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