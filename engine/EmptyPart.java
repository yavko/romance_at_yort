package engine;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.Image;

public class EmptyPart extends ScenePart {
    public EmptyPart() {
        super(null);
    }
 
    public void doAfter(Game game) {}
    
    public void changeUI(Game game) {
        JPanel panel = new utils.TransparentPanel(new FlowLayout(FlowLayout.LEADING, 10, 10));
        MouseListener listener = new MouseListener() {
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {
               call(game);
            }
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
        };
        
        panel.addMouseListener(listener);
        

        game.setCenterPanel(panel);
    }
}
