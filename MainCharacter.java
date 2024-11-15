public class MainCharacter extends engine.Character {
    public static String name;
    public static final String backgroundInfo = "to be written";
    public static int age = 18;
    public MainCharacter() {}
    public void displayEmotion(engine.Game game, engine.Emotion emote) {}
    public int getAge() { return age; }
    public void setAge(int newAge) { age = newAge; }
    public String getName() { return name; }
    public String getBackgroundInfo() { return backgroundInfo; }
}