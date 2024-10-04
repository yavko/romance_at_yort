package engine;

import javax.swing.*;

public abstract class GameScenePart {
    public void execute() {
        Runnable doUI = new Runnable() {
            public void run() {
                changeUI();   
            }
        };
        Runnable doDisplay = new Runnable() {
            public void run() {
                changeDisplay(); 
            }
        };
        SwingUtilities.invokeLater(doUI);
        SwingUtilities.invokeLater(doDisplay);
    };
    public abstract void changeUI();
    public abstract void changeDisplay();
}
