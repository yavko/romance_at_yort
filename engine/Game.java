package engine;
import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
    /**
     * Constructor for objects of class Game
     */
    private GameCanvas canvas;
    public Game(Image initImg) {
        this.canvas = new GameCanvas(initImg, new Character[]{});
        add(canvas);
        add(new JButton("hello world"));
    }
    // @Override
    // public void paintComponent(Graphics g) {
    // }

}
