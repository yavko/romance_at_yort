package engine;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Font;
import utils.WrappedText;
import utils.TransparentPanel;
import utils.BgPanel;
import java.awt.BorderLayout;

public class Dialogue extends ScenePart {
    private final String dialogue;
    private int index = 0;
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

    boolean typing = true;
    Timer timer = null;
    public void changeUI(Game game) {
        System.out.println("dialogue: " + dialogue);
        JPanel bottomPanel = new BgPanel(new BorderLayout(10, 10), game.getUISettings().getDialogueBg());
        JPanel centerPanel = new TransparentPanel(new FlowLayout(FlowLayout.LEADING, 10, 10));
        int fullH = game.size().height;
        int newH = (int)(fullH*0.3);
        double aspectRatio = 1731.0/335.0;
        bottomPanel.setPreferredSize(new Dimension((int)(newH*aspectRatio), newH));
        bottomPanel.setMaximumSize(new Dimension(1731, 335));
        String speaker = getCharacterName(game) != null ? getCharacterName(game) + ": " : "";

        WrappedText textLabel = new WrappedText(speaker);
        textLabel.setFont(game.getUISettings().getFont().deriveFont(20f));
        textLabel.setForeground(game.getUISettings().getTextColor());
        textLabel.setPreferredSize(new Dimension((int)((newH-10)*aspectRatio), newH-10));

        if (game.getUISettings().getTypewriterEnabled()) {
            timer = new Timer(50, new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textLabel.setText(textLabel.getText() + dialogue.charAt(index));
                        index++;
                        if (index >= dialogue.length()) {
                            timer.stop();
                            typing = false;
                        }
                    }
                });
            timer.start();
        } else typing = false;
        bottomPanel.add(new TransparentPanel(), BorderLayout.PAGE_START);
        bottomPanel.add(new TransparentPanel(), BorderLayout.LINE_START);
        bottomPanel.add(new TransparentPanel(), BorderLayout.LINE_END);

        bottomPanel.add(textLabel, BorderLayout.CENTER);
        MouseListener clickListener = new MouseListener() {
                public void mousePressed(MouseEvent e) {}

                public void mouseReleased(MouseEvent e) {
                    if (typing) {
                        timer.stop();
                        textLabel.setText(speaker + dialogue);
                        typing = false;
                    } else call(game);
                }

                public void mouseEntered(MouseEvent e) {}

                public void mouseExited(MouseEvent e) {}

                public void mouseClicked(MouseEvent e) {}
            };
        textLabel.addMouseListener(clickListener);
        bottomPanel.addMouseListener(clickListener);
        centerPanel.addMouseListener(clickListener);

        game.setPanels(centerPanel, bottomPanel);
    }
}