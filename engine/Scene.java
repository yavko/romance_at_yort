package engine;

import java.util.*;
import java.awt.Image;

public class Scene {
    private LinkedList<ScenePart> parts;
    private final Image bgImg;
    public Scene(ScenePart[] parts, Image bgImg) {
        this.parts = new LinkedList<>(Arrays.asList(parts));
        this.bgImg = bgImg;
    }
    public Scene(Image bgImg) {
        this.parts = new LinkedList<>();
        this.bgImg = bgImg;
    }
    public LinkedList<ScenePart> getParts() {
        return parts;
    }

    public Image getBgImg() {
        return bgImg;
    }
    public void execute(Game game) {
        parts.forEach(part -> part.execute(game));
    }
}
