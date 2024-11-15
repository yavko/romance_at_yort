import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Objects;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class EntryPoint extends JFrame {
    private JPanel content;
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
        
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName()
            );
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        try {
            loadOpeningScreen();
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }

        add(content);

        // window show & size
        pack();
        setVisible(true);
    }

    private void loadOpeningScreen() throws java.io.IOException {
        // Background
        URL bgImgUrl = EntryPoint.class.getResource("assets/opening_scene.png");
        BufferedImage bgImg = ImageIO.read(bgImgUrl);

        // Play btn

        JButton playBtn = new ImgButton(
            ImageIO.read(
                EntryPoint.class.getResource("assets/start_button.png")
            )
        );
        //playBtn.setPreferredSize(new Dimension(351, 170));

        // Panel w/ bg
        JPanel openingScreen = new BgPanel(new BorderLayout(), bgImg);

        openingScreen.add(playBtn, BorderLayout.PAGE_END);

        content = openingScreen;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EntryPoint::new);
    }

}
