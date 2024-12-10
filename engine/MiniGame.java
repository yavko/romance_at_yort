package engine;

import javax.swing.*;

public abstract class MiniGame extends ScenePart {
    /**
     * Constructor for objects of class MiniGame
     */
    protected MinigameDifficulty difficulty;
    public MiniGame(MinigameDifficulty difficulty) {
        super();
        this.difficulty = difficulty;
    }
}