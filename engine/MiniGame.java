package engine;

import javax.swing.*;

public abstract class MiniGame extends ScenePart {
    /**
     * Constructor for objects of class MiniGame
     */
    private MinigameDifficulty difficulty;
    protected Class winner;
    public MiniGame(MinigameDifficulty difficulty) {
        super();
        this.difficulty = difficulty;
    }
    public void finish(Class winner) {
        this.winner = winner;
    }
}