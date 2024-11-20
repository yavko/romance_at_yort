package engine;

public class Dialogue extends ScenePart {
    private final String dialogue;
    private final Class chrClass;
    public Dialogue(String dialogue, Class chrClass) {
        this.dialogue = dialogue;
        this.chrClass = chrClass;
        // other init logic
    }
    public void doAfter(Game game) {}
    public void changeDisplay(Game game) {}
    public void changeUI(Game game) {
        // display
    }
}
