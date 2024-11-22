package engine;
import java.awt.Image;

public abstract class Character {
    public abstract String getName();
    public abstract String getBackgroundInfo();
    public abstract int getAge();
    public abstract void setAge(int newAge);
    private int xPos;
    private int yPos;
    // actually percentage
    public int getXPos() { return xPos; }
    public int getYPos() { return yPos; }
    protected Character(int x, int y) {
        xPos = x;
        yPos = y;
    } 
    public void setXPos(int newX) { xPos = newX; }
    public void setYPos(int newY) { yPos = newY; }
    
    //public abstract void setEmotion(Emotion emote);
    //public abstract Emotion getEmotion();
    public abstract Image getCurrentImg();
}
