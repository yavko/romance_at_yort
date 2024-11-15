import javax.swing.*;
import java.awt.*;

public class ImgButton extends JButton {
    public ImgButton(Image img) {
        super(new ImageIcon(img));
        setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    }
}
