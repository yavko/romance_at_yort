package engine;

public abstract class TextInput extends ScenePart {
    private final String prompt;
    protected String inputtedText;
    private final Class chrClass;
    public TextInput(String pmpt,Class chrClass) {
        this.prompt = pmpt;
        this.chrClass = chrClass;
        // other init logic
    }
    public void changeDisplay(Game game) {
        // displays characters and stuff
    }
    public void changeUI(Game game) {
        // display's the actual choice
    }
}
