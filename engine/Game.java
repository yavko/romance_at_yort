package engine;
import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
    /**
     * Constructor for objects of class Game
     */
    private GameCanvas canvas;
    private Story story;
    public Game(Image initImg, Story story) {
        this.story = story;
        this.canvas = new GameCanvas(initImg, new Character[]{});
        add(canvas);
        add(new JButton("hello world"));
    }
    // @Override
    // public void paintComponent(Graphics g) {
    // }

}
