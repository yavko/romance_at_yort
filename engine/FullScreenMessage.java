package engine;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.Image;

public class FullScreenMessage extends ScenePart {
    private final String dialogue;
    public FullScreenMessage(String dialogue, Class chrClass) {
        super(chrClass);
        this.dialogue = dialogue;

        // other init logic
    }
    public FullScreenMessage(String dialogue) {
        super(null);
        this.dialogue = dialogue;
    }
    public void doAfter(Game game) {}
    
    public void changeUI(Game game) {
        JPanel panel = new utils.TransparentPanel(new FlowLayout(FlowLayout.LEADING, 10, 10));
        if (getCharacterName(game) != null)
            panel.add(new JLabel(getCharacterName(game) + ":"));
        panel.add(new JLabel(dialogue));
        panel.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {
               call(game);
            }
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
        });
        

        game.setCenterPanel(panel);
    }
}
