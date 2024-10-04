import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;
import com.github.weisj.jsvg.*;
import com.github.weisj.jsvg.parser.*;
import java.net.URL;

public class EntryPoint extends JFrame {
    public EntryPoint() {
        // window title
        super("main window");
        
        // sets window resizing/size behaviour
        setMinimumSize(new Dimension(400, 300));
        // !!TODO!! : Add actual resizing logic, cuz it DOES not exist ;(
        
        // creates close event
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                    EntryPoint.this,
                    "Do you want to close the game?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION
                );
                if (choice == JOptionPane.YES_OPTION) {
                    // !!TODO!! : add logic when closing here
                    EntryPoint.this.dispose();
                }
            }
        });
        
        SVGLoader loader = new SVGLoader();
        URL svgUrl = EntryPoint.class.getResource("placeholder_screen.svg");
        SVGDocument svgDocument = loader.load(svgUrl);
        add(new SVGComponent(svgDocument));
        
        // window show & size
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(EntryPoint::new);
    }

}
