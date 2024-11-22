package engine;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

public abstract class Choice extends ScenePart {
    private final String prompt;
    private final String choice1;
    private final String choice2;
    protected boolean choice1Picked;
    public Choice(String pmpt, String c1, String c2, Class chrClass) {
        super(chrClass);
        this.prompt = pmpt;
        this.choice1 = c1;
        this.choice2 = c2;
        // other init logic
    }
    public void changeUI(Game game) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 10));
        panel.add(new JLabel(getCharacterName(game)+":"));
        panel.add(new JLabel(prompt));
        JButton choice1Btn = new JButton(choice1);
        choice1Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice1Picked = true;
                call(game);
            }
        });
        panel.add(choice1Btn);
        
        JButton choice2Btn = new JButton(choice2);
        choice2Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice1Picked = false;
                call(game);
            }
        });
        panel.add(choice2Btn);

        game.setPanel(panel);
    }
}
