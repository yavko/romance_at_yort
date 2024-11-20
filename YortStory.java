import java.util.ArrayList;
import engine.*;

/**
 * class representing the game's story
 *
 * @author yavko
 * @version 0.1
 */
public class YortStory extends engine.Story {
    /**
     * Constructor for objects of class YortStory
     */
    public Difficulty difficulty;
    public YortStory(Difficulty difficulty) {
        super();
        // story logic
        
        // example scene for y'all to see how to do
        
        // adds scene with bg of "bedroom"
        addScene(new Scene(MiscAssets.backgrounds.get("bedroom")));
        
        // example of how to do difficulty specific stuff
        if (difficulty == Difficulty.Insane) {
            addPart(new Dialogue(
                "Fun fact: A monad of X is a monoid in the category of endofunctors of category X",
                Oswaldo.class
            ));
        } else {
            addPart(new Dialogue("Fun fact: Monads are cool", Oswaldo.class));
        }
        
        addPart(new Dialogue("Skibidi dom dom what?", MainCharacter.class) {
            @Override
            public void doAfter(Game game) {
                // could change emotion of characters or something
            }
        });
        addPart(new Choice("Art thou sigma?", "yes", "no", Oswaldo.class) {
            @Override
            public void doAfter(Game game) {
                if (!choice1Picked) // this comes from a property in Choice
                    System.out.println("'Tis skibidi, that is not being a sigma.");
            }
        }); 
    }
}
