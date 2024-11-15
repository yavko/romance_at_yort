package engine;

import javax.swing.*;

public abstract class ScenePart {
    public void execute(Game game) {
        Runnable doUI = new Runnable() {
            public void run() {
                changeUI(game);   
            }
        };
        Runnable doDisplay = new Runnable() {
            public void run() {
                changeDisplay(game); 
            }
        };
        SwingUtilities.invokeLater(doUI);
        SwingUtilities.invokeLater(doDisplay);
    };
    public abstract void changeUI(Game game);
    public abstract void changeDisplay(Game game);
}
