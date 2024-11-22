package engine;

import javax.swing.*;

public abstract class ScenePart {
    private final Class chrClass;
    protected ScenePart(Class chrClass) {
        this.chrClass = chrClass;
    }
    public String getCharacterName(Game game) {
        return game.getCanvas().getCharacter(chrClass).getName();
    }
    public abstract void doAfter(Game game);
    public void call(Game game) {
        doAfter(game);
        game.nextPart();
    }
    public abstract void changeUI(Game game);
}
