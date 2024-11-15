package engine;

public abstract class Character {
    public abstract String getName();
    public abstract String getBackgroundInfo();
    public abstract int getAge();
    public abstract void setAge(int newAge);

    public abstract void displayEmotion(Game game, Emotion emote);
}
