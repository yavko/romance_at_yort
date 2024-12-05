package engine;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

public class Dialogue extends ScenePart {
    private final String dialogue;
    public Dialogue(String dialogue, Class chrClass) {
        super(chrClass);
        this.dialogue = dialogue;
        // other init logic
    }
    public Dialogue(String dialogue) {
        super(null);
        this.dialogue = dialogue;
    }
    public void doAfter(Game game) {}
    
    public void changeUI(Game game) {
        System.out.println(dialogue);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 10));
        String buf = "";
        if (getCharacterName(game) != null)
            buf += getCharacterName(game) + ": ";
        buf += dialogue;
        panel.add(new JLabel(buf));
        panel.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {
               call(game);
            }
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
        });
        

        game.setPanel(panel);
    }
}
