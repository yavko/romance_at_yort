package engine;

import javax.swing.*;

public abstract class ScenePart {
    private final Class chrClass;
    protected ScenePart(Class chrClass) {
        this.chrClass = chrClass;
    }
    public String getCharacterName(Game game) {
        if (chrClass != null) {
            Character possibleChar = game.getCanvas().getCharacter(chrClass);
            if (possibleChar != null)
                return possibleChar.getName();
            }
        return null;
    }
    public abstract void doAfter(Game game);
    public void call(Game game) {
        doAfter(game);
        game.nextPart();
    }
    public abstract void changeUI(Game game);
}
