/**
 * Enumeration class Difficulty - represents possible difficulty
 *
 * @author yavko
 * @version 0.1
 */
import engine.MinigameDifficulty;

public enum Difficulty {
    Impossible, Normal, Easy;
    
    public MinigameDifficulty asMinigameDifficulty() {
        switch (this) {
            case Impossible:
                return MinigameDifficulty.Hard;
            case Normal:
                return MinigameDifficulty.Medium;
            case Easy:
            default:
                return MinigameDifficulty.Basic;
        }
    }
}
