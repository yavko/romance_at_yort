
/**
 * Write a description of class Stats here.
 *
 * @author Ashlyn Yi
 * @version 0.1
 */
public class YortStats
{
    private int  favorability;
    public int getFavorability(){
        return favorability;
    }
    public void setFavorability(int value){
        favorability = value;
    }
    public void changeFavorability(int delta){
        favorability += delta;
    }
    public YortStats(int initFav) {
        this.favorability = initFav;
    }
}
