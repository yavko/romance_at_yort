package engine;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Game<T> extends utils.BgPanel {
    /**
     * Constructor for objects of class Game
     */
    private GameCanvas canvas;
    private final Story story;
    private T dataStore;
    public Game(Image gameBg, Story story, T dataStore) {
        super(new BorderLayout(10, 10), gameBg);
        this.story = story;
        this.dataStore = dataStore;
        this.canvas = new GameCanvas(gameBg, new Character[0]);
        add(canvas, BorderLayout.CENTER);
        add(new JButton("hello world"), BorderLayout.PAGE_END);
    }
    public void next() {
        LinkedList<Scene> list = story.getScenes();
        if (list.peek() != null && list.peek().getParts().peek() == null) {
            list.poll()
        }
    }
    public T getData(){
        return dataStore;
    }
    // @Override
    // public void paintComponent(Graphics g) {
    // }

}
