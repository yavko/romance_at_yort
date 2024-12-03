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
    public int affectionMeter;
    public boolean rightChoice = true;
    public YortStory(Difficulty difficulty) {
        super();
        if(difficulty == Difficulty.Easy){
            affectionMeter = 75;
        }
        else if(difficulty == Difficulty.Normal){
            affectionMeter = 50;
        }
        else{
            affectionMeter = 25;
        }
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
        
         addPart(new Choice("what do you do?", "yes", "no", "maybe") {
            @Override
            public void doAfter(Game game) {
                if (choice1Picked){ // this comes from a property in Choice
                    condScene(new Scene(
                        MiscAssets.backgrounds.get("brrrwayGood")));
    
                    condPart(
                        new EmptyPart()
                    );
                }
                else if(choice2Picked){
                    condScene(new Scene(
                        MiscAssets.backgrounds.get("brrrwayrude")));
            
                    condPart(
                        new EmptyPart());
                }
                else{
                    condScene(new Scene(
                        MiscAssets.backgrounds.get("brrrwaymysterious")));
            
                    condPart(
                        new EmptyPart());
                }
                }
        });
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("ticTacToe")));
            
        addPart(
            new EmptyPart()
        );
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("tttSit")));
            
        addPart(
            new EmptyPart()
        );
        
        addPart(new Choice("Will you play Tic Tac Toe", "yes", "no") {
            @Override
            public void doAfter(Game game) {
                if (!choice1Picked){ // this comes from a property in Choice
                    if (difficulty == Difficulty.Impossible){ // this comes from a property in Choice
                        condScene(new Scene(
                            MiscAssets.backgrounds.get("rejectTTT")));
            
                        addPart(
                            new EmptyPart());
                    }
                    else if(difficulty == Difficulty.Normal){
                        condScene(new Scene(
                            MiscAssets.backgrounds.get("hwStudy")));
            
                        condPart(
                            new EmptyPart());
                    }
                    
                    }
                else{
                    condScene(new Scene(
                        MiscAssets.backgrounds.get("winOrLose")));
            
                    condPart(new Choice("Play to win?", "yes", "no") {
                    @Override
                    public void doAfter(Game game) {
                        if (difficulty == Difficulty.Easy) // this comes from a property in Choice
                            System.out.println("'Tis skibidi, that is not being a sigma.");
                        else if(difficulty == Difficulty.Normal){
                            
                        }
                        else{
                            
                        }
                        }
                    });
                }
                }
        });
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("dance")));
            
        addPart(
            new EmptyPart()
        );
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("danceSit")));
            
        addPart(
            new EmptyPart()
        );
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("outfitSit")));

        addPart(new Choice("what will you wear?", "green dress", "girluniform", "guyuniform") {
            @Override
            public void doAfter(Game game) {
                if(choice1Picked){
                }
                else if(choice2Picked){
                    
                }
                else{
                    
                }  
            }
        });
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("dancePartner")));
            
        addPart(new Choice("dance with oswaldo?", "yes", "no") {
            @Override
            public void doAfter(Game game) {
                if(choice1Picked){
                }
                else{
                    
                }
            }
        });
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("hangout")));
            
        addPart(new Choice("dance with oswaldo?", "yes", "no") {
            @Override
            public void doAfter(Game game) {
                if(choice1Picked){
                }
                else{
                    
                }
            }
        });
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("graduation")));
            
        addPart(
            new EmptyPart()
        );
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("gradSit")));
            
        addPart(new Choice("what do you do?", "friendzone", "confession", "nothing") {
            @Override
            public void doAfter(Game game) {
                if(choice1Picked){
                    condScene(new Scene(
                        MiscAssets.backgrounds.get("gradFriendZone")));
            
                    condPart(
                        new EmptyPart()
                    );
                }
                else if(choice3Picked){
                    condScene(new Scene(
                        MiscAssets.backgrounds.get("noGradBye")));
            
                    condPart(
                        new EmptyPart()
                    );
                }
                else{
                    
                }
            }
        });
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("endScene")));
            
        addPart(
            new EmptyPart()
        );
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("marriageSit")));
            
        addPart(
            new EmptyPart()
        );
        
        addScene(new Scene(
            MiscAssets.backgrounds.get("choicebg")));
            
        addPart(new Choice("say yes?", "yes", "no") {
            @Override
            public void doAfter(Game game) {
                if(choice1Picked){
                    condScene(new Scene(
                        MiscAssets.backgrounds.get("happyEnding")));
            
                    condPart(
                        new EmptyPart()
                    );
        
                }
                else{
                    condScene(new Scene(
                        MiscAssets.backgrounds.get("rejectProposal")));
            
                    condPart(
                        new EmptyPart()
                    );
        
                }
            }
        });
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
        
        addPart(new Choice("Play to win?", "yes", "no") {
            @Override
                public void doAfter(Game game) {
                    if(choice1Picked){
                        
                    }
                    else{
                        
                    }
                }
        });
    }
    // only needed cuz of type erasure, so i
    // cant override generics in the way i want to
    private YortData data(Game game) {
        return (YortData)game.getData();
    }
}
