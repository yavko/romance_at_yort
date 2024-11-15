package engine;
import java.util.*;

public class Scene {
    private ArrayList<ScenePart> parts;
    public Scene(ScenePart[] parts) {
        this.parts = new ArrayList<>(Arrays.asList(parts));
    }
    public ArrayList<ScenePart> getParts() {
        return parts;
    }
    public void execute(Game game) {
        parts.forEach(part -> part.execute(game));
    }
}
