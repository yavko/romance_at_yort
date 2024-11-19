package engine;
import java.util.ArrayList;

/**
 * Abstract class representing the game's story
 *
 * @author yavko
 * @version 0.1
 */
public abstract class Story {
    /**
     * Constructor for objects of class Story
     */
    public Story() {
        this.scenes = new ArrayList<>();
    }
    private ArrayList<Scene> scenes;
    public ArrayList<Scene> getScenes() {
        return scenes;
    }
}
