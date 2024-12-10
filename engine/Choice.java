package engine;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.awt.FlowLayout;
import utils.WrappedTextBg;
import utils.TransparentPanel;
import java.awt.Image;

public abstract class Choice extends ScenePart {
    private final String prompt;
    private final String choice1;
    private final String choice2;
    private final String choice3;
    protected boolean choice1Picked;
    protected boolean choice2Picked;
    protected boolean choice3Picked;
    public Choice(String pmpt, String c1, String c2, Class chrClass) {
        super(chrClass);
        this.prompt = pmpt;
        this.choice1 = c1;
        this.choice2 = c2;
        this.choice3 = null;
    }
    public Choice(String pmpt, String c1, String c2) {
        super(null);
        this.prompt = pmpt;
        this.choice1 = c1;
        this.choice2 = c2;
        this.choice3 = null;
    }
    public Choice(String pmpt, String c1, String c2, String c3) {
        super(null);
        this.prompt = pmpt;
        this.choice1 = c1;
        this.choice2 = c2;
        this.choice3 = c3;
    }
    enum C {
        Choice1, Choice2, Choice3
    }
    private WrappedTextBg createChoiceBtn(Game game, String text, C choice) {
        Image bg;
        if (choice3 == null)
            bg = game.getUISettings().getButton2Bg();
        else bg = game.getUISettings().getButton3Bg();
        WrappedTextBg choiceBtn = new WrappedTextBg(text, bg);
        choiceBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (choice == C.Choice1)
                    choice1Picked = true;
                else if (choice == C.Choice2)
                    choice2Picked = true;
                else
                    choice3Picked = true;
                call(game);
            }
        });
        return choiceBtn;
    }
    public void changeUI(Game game) {
        JPanel mainPanel = new TransparentPanel(new GridBagLayout());
        JPanel contentPanel = new TransparentPanel();
        JPanel buttonPanel = new TransparentPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        mainPanel.add(contentPanel);
        //if (getCharacterName(game) != null)
        //    panel.add(new JLabel(getCharacterName(game)+":"));
        JLabel promptLabel = new JLabel(prompt);
        promptLabel.setFont(game.getUISettings().getFont().deriveFont(50f));
        promptLabel.setForeground(game.getUISettings().getTextColor());
        contentPanel.add(promptLabel);
        contentPanel.add(buttonPanel);
        
        buttonPanel.add(createChoiceBtn(game, choice1, C.Choice1));
        buttonPanel.add(createChoiceBtn(game, choice2, C.Choice2));
        if (choice3 != null)
            buttonPanel.add(createChoiceBtn(game, choice3, C.Choice3));
            
        game.setCenterPanel(mainPanel);
    }
}
