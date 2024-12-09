package engine;
import javax.swing.*;
import javax.swing.BoxLayout;
import java.awt.event.*;
import java.awt.GridBagLayout;

public abstract class Input extends ScenePart {
    private final String prompt;
    public String inputtedText;
    public Input(String pmpt) {
        super();
        this.prompt = pmpt;
    }

    public void changeUI(Game game) {
        JPanel mainPanel = new utils.TransparentPanel(new GridBagLayout());
        JPanel contentPanel = new utils.TransparentPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel,BoxLayout.Y_AXIS));
        mainPanel.add(contentPanel);
        JLabel promptLabel = new JLabel(prompt);
        promptLabel.setFont(game.getUISettings().getFont().deriveFont(50f));
        promptLabel.setForeground(game.getUISettings().getTextColor());
        contentPanel.add(promptLabel);
        JTextField field = new JTextField(20);
        contentPanel.add(field);
        JButton btn = new JButton("submit");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputtedText = field.getText();
                call(game);
            }
        });
        contentPanel.add(btn);
        
        game.setCenterPanel(mainPanel);
    }
}
