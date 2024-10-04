import javax.swing.*;
import java.awt.Dimension;

public class EntryPoint extends JFrame {
    public EntryPoint() {
        super("main window");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        add(new JLabel("Game placeholder"));
        setMinimumSize(new Dimension(400, 300));
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(EntryPoint::new);
    }

}
