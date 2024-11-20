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
    /**
     * Method getScenes returns all of the Scenes in Story
     *
     * @return returns an ArrayList holding every Scene
     */
    public ArrayList<Scene> getScenes() {
        return scenes;
    }
    /**
     * Method addScene adds a scene to the story
     *
     * @param scene The scene to add
     */
    public void addScene(Scene scene) {
        scenes.add(scene);
    }
    /**
     * Method addPart adds a ScenePart to the last added Scene
     *
     * @param part The ScenePart to be added
     */
    public void addPart(ScenePart part) {
        scenes.get(scenes.size()-1).getParts().add(part);
    }
}
