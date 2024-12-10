package engine;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.awt.FlowLayout;
import utils.WrappedTextBg;
import utils.TransparentPanel;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;

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
        double aspectRatio;
        double percentOfScreen;
        Font font = null;
        if (choice3 == null) {
            bg = game.getUISettings().getButton2Bg();
            aspectRatio = 741.0/572.0;
            percentOfScreen = 0.4;
            font = game.getUISettings().getFont().deriveFont(30f);
        }
        else {
            bg = game.getUISettings().getButton3Bg();
            aspectRatio = 516.0/685.0;
            percentOfScreen = 7.0/12.0;
            font = game.getUISettings().getFont().deriveFont(20f);
        }
        int fullH = game.size().height;
        int newH = (int)(fullH*percentOfScreen);
        int newW = (int)(newH*aspectRatio);
        WrappedTextBg choiceBtn = new WrappedTextBg(text, bg);
        choiceBtn.setFont(font);
        choiceBtn.setForeground(game.getUISettings().getTextColor());
        choiceBtn.setPreferredSize(new Dimension(newW, newH));
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
        choiceBtn.setBorder(new EmptyBorder(100, 30, 10, 30));
        return choiceBtn;
    }
    public void changeUI(Game game) {
        JPanel mainPanel = new TransparentPanel(new BorderLayout());
        JPanel contentPanel = new TransparentPanel();
        JPanel textPanel = new TransparentPanel(new GridBagLayout());
        JPanel buttonPanel = new TransparentPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        mainPanel.add(contentPanel, BorderLayout.PAGE_END);
        
        JLabel promptLabel = new JLabel(prompt);
        promptLabel.setFont(game.getUISettings().getFont().deriveFont(50f));
        promptLabel.setForeground(game.getUISettings().getTextColor());
        textPanel.add(promptLabel);
        contentPanel.add(textPanel);
        contentPanel.add(buttonPanel);
        
        buttonPanel.add(createChoiceBtn(game, choice1, C.Choice1));
        buttonPanel.add(createChoiceBtn(game, choice2, C.Choice2));
        if (choice3 != null)
            buttonPanel.add(createChoiceBtn(game, choice3, C.Choice3));
            
        game.setCenterPanel(mainPanel);
    }
}
