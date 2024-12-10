package engine;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.Image;
import java.util.function.*;
import utils.WrappedText;
import utils.TransparentPanel;
import utils.BgPanel;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FontMetrics;
import java.awt.Font;


public class FullScreenMessage extends ScenePart {
    private String dialogue = null;
    private Supplier<String> dialogueSupplier = null;
    public FullScreenMessage(String dialogue, Class chrClass) {
        super(chrClass);
        this.dialogue = dialogue;

        // other init logic
    }
    public FullScreenMessage(String dialogue) {
        super(null);
        this.dialogue = dialogue;
    }
    public FullScreenMessage(Supplier<String> dialogueSupplier) {
        super(null);
        this.dialogueSupplier = dialogueSupplier;
    }
    public void doAfter(Game game) {}
    
    public void changeUI(Game game) {
        JPanel panel = new utils.TransparentPanel(new BorderLayout(120,70));
        if (getCharacterName(game) != null)
            panel.add(new JLabel(getCharacterName(game) + ":"));
        String text =
            dialogue != null ?
                dialogue : // if not null
                dialogueSupplier.get(); // if null
        WrappedText textLabel = new WrappedText(text);
        panel.add(new TransparentPanel(), BorderLayout.PAGE_START);
        panel.add(new TransparentPanel(), BorderLayout.LINE_START);
        panel.add(new TransparentPanel(), BorderLayout.LINE_END);
        panel.add(textLabel, BorderLayout.CENTER);
        textLabel.setFont(game.getUISettings().getFont().deriveFont(15f));
        textLabel.setForeground(game.getUISettings().getTextColor());
        textLabel.setPreferredSize(new Dimension((int)(game.size().width*0.7), (int)(game.size().height*0.7)));
        MouseListener clickListener = new MouseListener() {
                public void mousePressed(MouseEvent e) {}

                public void mouseReleased(MouseEvent e) {
                    call(game);
                }

                public void mouseEntered(MouseEvent e) {}

                public void mouseExited(MouseEvent e) {}

                public void mouseClicked(MouseEvent e) {}
            };
        
        panel.addMouseListener(clickListener);
        textLabel.addMouseListener(clickListener);

        game.setCenterPanel(panel);
    }
}


// vendored from https://stackoverflow.com/a/17764625
class FontMetricsWrapper extends FontMetrics {

    private final FontMetrics target;

    public FontMetricsWrapper(FontMetrics target) {
        super(target.getFont());
        this.target = target;
    }

    @Override
    public int bytesWidth(byte[] data, int off, int len) {
        return target.bytesWidth(data, off, len);
    }

    @Override
    public int charWidth(char ch) {
        return target.charWidth(ch);
    }

    @Override
    public int charWidth(int codePoint) {
        return target.charWidth(codePoint);
    }
}