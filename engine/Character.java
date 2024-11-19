package engine;
import java.awt.Image;

public abstract class Character {
    public abstract String getName();
    public abstract String getBackgroundInfo();
    public abstract int getAge();
    public abstract void setAge(int newAge);
    public abstract int getXPos();
    public abstract int getYPos();
    
    public abstract void setEmotion(Emotion emote);
    public abstract Emotion getEmotion();
    public abstract Image getCurrentImg();
}
