
/**
 * Write a description of class Stats here.
 *
 * @author Ashlyn Yi
 * @version 0.1
 */
public class YortStats extends engine.Stats {
    private int  favorability;
    private String name;
    public int getFavorability(){
        return favorability;
    }
    public void setFavorability(int value){
        favorability = value;
    }
    public void changeFavorability(int delta){
        favorability += delta;
    }
    public void setName(String nameInput){
        name = nameInput;
    }
    public YortStats(int initFav) {
        this.favorability = initFav;
    }
}
