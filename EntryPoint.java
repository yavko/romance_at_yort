import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Objects;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.sound.sampled.Clip;
import java.io.File;

public class EntryPoint extends JFrame {
    private JPanel content;
    public void swapContent(JPanel newContent) {
        remove(content);
        this.content = newContent;
        add(content);
        revalidate();
        repaint(); // not sure if needed
    }
    public EntryPoint() {
        // window title
        super("main window");

        // sets window resizing/size behaviour
        setMinimumSize(new Dimension(854, 480));
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
        } catch (Exception e) {
            // handle exception
        }//*/

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
        // URL bgImgUrl = EntryPoint.class.getResource("assets/opening_scene.png");
        // BufferedImage bgImg = ImageIO.read(bgImgUrl);

        // Play btn
        Clip clip = engine.MediaPlayer.createClip("./audio/Main theme.wav", true);
        clip.start();
        JButton playBtn = new utils.ImgButton(
            ImageIO.read(
                EntryPoint.class.getResource("assets/start_button.png")
            ),
            0.2
        );
        
        Font textFont = null;
        try {
            textFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/text-reg.ttf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        engine.UISettings uiSettings = new engine.UISettings(
            textFont, // text font used
            Color.decode("#543938"), // main fg text color
            ImageIO.read(
                EntryPoint.class.getResource("assets/start_button.png") // button bg
            ),
            ImageIO.read(
                EntryPoint.class.getResource("assets/textboxbg.png") // dialogue textbox
            ),
            0.2, // button size
            true, // scene fading enabled
            true // typewriter effect enabled
        );
        
        playBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("starting game");
                clip.stop();
                swapContent(
                    new engine.Game<YortData>(
                        MiscAssets.backgrounds.get("base"),
                        new YortStory(Difficulty.Easy),
                        new YortData(0),
                        uiSettings,
                        EntryPoint.this
                    )
                );
            }
        });
        //playBtn.setPreferredSize(new Dimension(351, 170));

        // Panel w/ bg
        JPanel openingScreen = new utils.BgPanel(new BorderLayout(), MiscAssets.backgrounds.get("main"));

        openingScreen.add(playBtn, BorderLayout.PAGE_END);

        content = openingScreen;
    }

    public static void main(String[] args) {
        System.out.println(MiscAssets.backgrounds);
        SwingUtilities.invokeLater(EntryPoint::new);
    }

}
