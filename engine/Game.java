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
    private JPanel panel;
    public Game(Image gameBg, Story story, T dataStore) {
        super(new BorderLayout(10, 10), gameBg);
        //super(gameBg);
        //super.setLayout(new OverlayLayout(this));
        this.story = story;
        this.dataStore = dataStore;
        this.canvas = new GameCanvas();
        this.canvas.setMaximumSize(new Dimension(1920, 1080));
        nextScene();
        nextPart();
        add(canvas, BorderLayout.CENTER);
    }
    public void setPanel(JPanel newPanel) {
        if (panel != null) { 
            remove(panel);
            this.panel = newPanel;
            add(newPanel, BorderLayout.PAGE_END);
            revalidate();
            repaint(); // not sure if needed
        } else {
            this.panel = newPanel;
            add(newPanel, BorderLayout.PAGE_END);
        }
    }
    private Scene currentScene;
    private ScenePart currentScenePart; // needs to be rendered
    //private boolean finished = false;
    public void nextScene() {
        Scene nextScene = story.getScenes().poll();
        if (nextScene != null ) {
            currentScene = nextScene;
            canvas.setBgImg(currentScene.getBgImg());
            canvas.setCharacters(currentScene.getCharacters());
        } else {
            System.out.println("game has been completed");
            //finished = true;
            currentScene = null;
        }
    }
    public void nextPart() {        
        if (currentScene != null) {
            ScenePart part = currentScene.getParts().poll();
            if (part != null) {
                currentScenePart = part;
                part.changeUI(this);
            } else {
                nextScene();
                nextPart();
            }
        }
    }
    public GameCanvas getCanvas() {
        return canvas;
    }
    public T getData(){
        return dataStore;
    }
    public JPanel getPanel() { return panel; }
}
