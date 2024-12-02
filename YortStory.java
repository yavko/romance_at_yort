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
        
        // PLACEGHOLDER PLZ FIX LATER YES
        MainCharacter.name = "placeholder";
        
        // story logic
        addScene(new Scene(
            MiscAssets.backgrounds.get("base")));
            
        addPart(
            new FullScreenMessage(
                MiscAssets.generateBackgroundInfo(MainCharacter.name)
            )
        );
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("bgPt2")));
            
        addPart(
            new FullScreenMessage(
                MiscAssets.generateBackgroundInfo2(MainCharacter.name)
            )
        );
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("directions")));
            
        addPart(
            new FullScreenMessage(
                MiscAssets.generateWelcomeText(MainCharacter.name)
            )
        );
            
        addScene(new Scene(
            MiscAssets.backgrounds.get("welcome")));
            
        addPart(
            new EmptyPart()
        );
            
        addScene(new Scene(
            MiscAssets.backgrounds.get("introDiff")));
            
        addScene(new Scene(
            MiscAssets.backgrounds.get("brrrwayMeeting")));
            
        addPart(
            new EmptyPart()
        );
            
        addScene(new Scene(
            MiscAssets.backgrounds.get("brrrwaySit")));
            
        addPart(
            new EmptyPart()
        );
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("choicebg")));
        
         addPart(new Choice("Art thou sigma?", "yes", "no", "maybe") {
            @Override
            public void doAfter(Game game) {
                if (!choice1Picked) // this comes from a property in Choice
                    System.out.println("'Tis skibidi, that is not being a sigma.");
                }
        });
        addScene(new Scene(
            MiscAssets.backgrounds.get("brrrwayGood")));

        addPart(
            new EmptyPart()
        );
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("brrrwayrude")));

            
        // example scene for y'all to see how to do
        
        // adds scene with bg of "bedroom"
        // addScene(new Scene(
            // MiscAssets.backgrounds.get("bedroom"),
            // new engine.Character[] {
                // new Oswaldo(0,0),
                // new BoJiden(50, 50)
            // }
        // ));
        
        // example of how to do difficulty specific stuff
        if (difficulty == Difficulty.Impossible) {
            addPart(new Dialogue(
                "Fun fact: A monad of X is a monoid in the category of endofunctors of category X",
                Oswaldo.class
            ));
        } else {
            addPart(new Dialogue("Fun fact: Monads are cool"));
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
    // only needed cuz of type erasure, so i
    // cant override generics in the way i want to
    private YortData data(Game game) {
        return (YortData)game.getData();
    }
}
