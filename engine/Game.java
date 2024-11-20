package engine;
import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
    /**
     * Constructor for objects of class Game
     */
    private GameCanvas canvas;
    private Story story;
    private Stats stats;
    public Game(Image initImg, Story story, Stats stats) {
        this.story = story;
        this.stats = stats;
        this.canvas = new GameCanvas(initImg, new Character[]{});
        add(canvas);
        add(new JButton("hello world"));
    }
    public Stats getStats(){
        return stats;
    }
    // @Override
    // public void paintComponent(Graphics g) {
    // }

}
