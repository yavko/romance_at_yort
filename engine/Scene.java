package engine;

import java.util.*;
import java.awt.Image;

public class Scene {
    private LinkedList<ScenePart> parts;
    private final Image bgImg;
    private HashSet<Character> characters;
    public Scene(ScenePart[] parts, Image bgImg, Character[] chars) {
        this.parts = new LinkedList<>(Arrays.asList(parts));
        this.bgImg = bgImg;
        this.characters = new HashSet<>(Arrays.asList(chars));
    }
    public Scene(Image bgImg, Character[] chars) {
        this.parts = new LinkedList<>();
        this.bgImg = bgImg;
        this.characters = new HashSet<>(Arrays.asList(chars));
    }
    public void setCharacters(final HashSet<Character> characters) {
        this.characters = characters;
    }
    public HashSet<Character> getCharacters() {
        return characters;
    }
    public LinkedList<ScenePart> getParts() {
        return parts;
    }

    public Image getBgImg() {
        return bgImg;
    }
}
