package engine;

import java.util.*;
import java.awt.Image;

public class Scene {
    private ArrayList<ScenePart> parts;
    private final Image bgImg;
    public Scene(ScenePart[] parts, Image bgImg) {
        this.parts = new ArrayList<>(Arrays.asList(parts));
        this.bgImg = bgImg;
    }
    public Scene(Image bgImg) {
        this.parts = new ArrayList<>();
        this.bgImg = bgImg;
    }
    public ArrayList<ScenePart> getParts() {
        return parts;
    }

    public Image getBgImg() {
        return bgImg;
    }
    public void execute(Game game) {
        parts.forEach(part -> part.execute(game));
    }
}
