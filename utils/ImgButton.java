package utils;

import javax.swing.*;
import java.awt.*;

public class ImgButton extends JButton {
    
    /**
     * ImgButton Constructor
     *
     * @param img the image used by the button
     * @param newWidth if not null, scales image by factor
     */
    public ImgButton(Image img, Double scaleFactor) {
        super();
        if (scaleFactor != null)
            setIcon(new ImageIcon(
                img.getScaledInstance(
                    (int)(img.getWidth(this)*scaleFactor),
                    (int)(img.getHeight(this)*scaleFactor),
                    Image.SCALE_DEFAULT
                )
            ));
        else
            setIcon(new ImageIcon(img));
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
