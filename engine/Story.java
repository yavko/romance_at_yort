package engine;
import java.util.LinkedList;

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
        this.scenes = new LinkedList<>();
    }
    private LinkedList<Scene> scenes;
    /**
     * Method getScenes returns all of the Scenes in Story
     *
     * @return returns an ArrayList holding every Scene
     */
    public LinkedList<Scene> getScenes() {
        return scenes;
    }
    /**
     * Method addScene adds a scene to the story
     *
     * @param scene The scene to add
     */
    public void addScene(Scene scene) {
        scenes.addLast(scene);
    }
    /**
     * Method addPart adds a ScenePart to the last added Scene
     *
     * @param part The ScenePart to be added
     */
    public void addPart(ScenePart part) {
        scenes.getLast().getParts().add(part);
    }
}
