package engine;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.Image;

public class NullPart extends ScenePart {
    public NullPart() {
        super(null);
    }
 
    public void doAfter(Game game) {}
    
    public void changeUI(Game game) {
        call(game);
    }
}
