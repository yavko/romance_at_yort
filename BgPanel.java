import javax.swing.*;
import java.awt.*;

public class BgPanel extends JPanel {
    private Image img;
    public BgPanel(LayoutManager layout, Image i) {
        super(layout);
        this.img = i;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
