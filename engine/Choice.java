package engine;

public abstract class Choice extends ScenePart {
    private final String prompt;
    private final String choice1;
    private final String choice2;
    public Choice(String pmpt, String c1, String c2) {
        this.prompt = pmpt;
        this.choice1 = c1;
        this.choice2 = c2;
        // other init logic
    }
    public void changeDisplay(Game game) {
        // displays characters and stuff
    }
    public void changeUI(Game game) {
        // display's the actual choice
    }
}
