package engine;
import java.awt.*;

/**
 * Settings for the UI of the game
 *
 * @author Yavor Kolev
 * @version 0.1.0
 */
public class UISettings {
    private Font textFont;
    private Color textColor;
    private Image buttonBg;
    private Image dialogueBg;
    private double buttonSize;
    private boolean fadeScenes;
    private boolean typewriterEnabled;
    
    public Font getFont() {
        return textFont;
    }
    public Color getTextColor() {
        return textColor;
    }
    public Image getButtonBg() {
        return buttonBg;
    }
    public Image getDialogueBg() {
        return dialogueBg;
    }
    public double getButtonSize() {
        return buttonSize;
    }
    public boolean getFadeScenes() {
        return fadeScenes;
    }
    public boolean getTypewriterEnabled() {
        return typewriterEnabled;   
    }
    
    /**
     * Constructor for objects of class UISettings
     */
    public UISettings(
        Font textFont,
        Color textColor,
        Image buttonBg,
        Image dialogueBg,
        double buttonSize,
        boolean fadeScenes,
        boolean typewriterEnabled
    ) {
        this.textFont = textFont;
        this.textColor = textColor;
        this.buttonBg = buttonBg;
        this.dialogueBg = dialogueBg;
        this.buttonSize = buttonSize;
        this.fadeScenes = fadeScenes;
        this.typewriterEnabled = typewriterEnabled;
    }
}