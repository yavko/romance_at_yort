import java.awt.*;
import javax.swing.*;
import com.github.weisj.jsvg.*;
import com.github.weisj.jsvg.attributes.ViewBox;

class SVGComponent extends JComponent {
    private SVGDocument svgDocument;
    public SVGComponent(SVGDocument s) {
        this.svgDocument = s;
    }
    // from: https://github.com/weisJ/jsvg/#rendering
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        svgDocument.render(this, (Graphics2D) g, new ViewBox(0, 0, getWidth(), getHeight()));
    }
}