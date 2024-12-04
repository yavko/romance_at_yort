import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;

public class TestingGame extends JFrame implements KeyListener {
    public TestingGame() {
        super("testing game window");
        setMinimumSize(new Dimension(854, 480));
        //
        
        //
        addKeyListener(this);
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TestingGame::new);
    }
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch(keyCode) { 
            case KeyEvent.VK_UP:
                // handle up
                
                break;
            case KeyEvent.VK_DOWN:
                // handle down 
                break;
            case KeyEvent.VK_LEFT:
                // handle left
                break;
            case KeyEvent.VK_RIGHT:
                // handle right
                break;
        }
    }
    
    
}
