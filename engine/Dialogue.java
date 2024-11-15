package engine;

public abstract class Dialogue extends ScenePart {
    private final String dialogue;
    public Dialogue(String dialogue) {
        this.dialogue = dialogue;
        // other init logic
    }
    public void changeDisplay(Game game) {}
    public void changeUI(Game game) {
        // display
    }
}
