import javax.swing.*;

public abstract class TicTacToe extends engine.ScenePart {
    /**
     * Constructor for objects of class MiniGame
     */
    private engine.MinigameDifficulty difficulty;
    protected Class winner;
    public TicTacToe(engine.MinigameDifficulty difficulty) {
        super();
        this.difficulty = difficulty;
    }
    public void finish(Class winner) {
        this.winner = winner; 
    }
}
