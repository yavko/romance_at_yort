import java.util.ArrayList;
import engine.*;
import javax.sound.sampled.Clip;


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
    public int affectionMeter = 50;
    public boolean rightChoice = true;
    public YortStory(Difficulty difficulty) {
        super();
        // PLACEGHOLDER PLZ FIX LATER YES
        
        MainCharacter.name = "placeholder";

        // story logic
        addScene(new Scene(
                MiscAssets.backgrounds.get("base")));
        Clip clip = engine.MediaPlayer.createClip("./audio/buttonClick.wav", true);
        addPart(
            new FullScreenMessage(
                MiscAssets.generateBackgroundInfo(MainCharacter.name)
            ) {
                @Override
                public void onLoad(Game game) {
                // play audio
                clip.start();
                }
                @Override
                public void doAfter(Game game) {
                // stop audio
                clip.stop();
                }
                }
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
            new EmptyPart());

        addScene(new Scene(
                MiscAssets.backgrounds.get("welcome")));

        addPart(
            new FullScreenMessage(
                MiscAssets.generateWelcomeText(MainCharacter.name)
            )
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

        addPart(new Choice("what do you do?", "say sorry", "be rude", "whip those luscious locks!!") {
                @Override
                public void doAfter(Game game) {
                    condScene(new Scene(
                            MiscAssets.backgrounds.get("hallwaybg"),
                            new engine.Character[] {
                                new Oswaldo(0,0)
                            }
                        ));
                    System.out.println("logic in question");
                    if (choice1Picked){ // this comes from a property in Choice

                        condPart(new Dialogue("“Hey, no worries at all! It was an accident. I’m sure you didn’t mean to. My name is Oswaldo and I hope to see you around often!” You thank him again and run over to your next class, leaving him with a good impression of you.", Oswaldo.class));
                        if(difficulty == Difficulty.Easy){
                            affectionMeter += 15;
                        } else if(difficulty == Difficulty.Normal){
                            affectionMeter += 10;
                        }
                        else{
                            affectionMeter +=5;
                        }
                    } else if(choice2Picked){
                        rightChoice = false;
                        if(difficulty == Difficulty.Normal){
                            affectionMeter -= 5;
                        }else if(difficulty == Difficulty.Impossible){
                            affectionMeter -= 20;
                        }
                        condPart(new Dialogue("Oswaldo, the guy you bumped into, looks at you confused, but as he is polite, he doesn’t want to cause a big scene. “Hey, no need to be rude. It was an accident.”", Oswaldo.class));
                    } else{
                        if(difficulty == Difficulty.Normal){
                            condPart(new Dialogue("He now has an interest of neither dislike nor like of you.", CoJoglianese.class));
                        }else if(difficulty == Difficulty.Impossible){
                            affectionMeter -= 10;
                        }

                        condPart(new Dialogue("The guy you bumped into was Oswaldo. He looks at you as if waiting for you to say something, but you don’t.", Oswaldo.class));
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
                    if (choice1Picked){ // this comes from a property in Choice
                        /*condPart(new TicTacToe(engine.MinigameDifficulty.Random) {
                        @Override
                        public void doAfter(Game game) {
                        }
                        });*/

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("coJogClass")));

                        if(true)
                        {
                            if(difficulty == Difficulty.Easy){
                                affectionMeter += 15;
                            } else if(difficulty == Difficulty.Normal){
                                affectionMeter += 10;
                            }else{
                                affectionMeter +=1;
                            }

                            condPart(new Dialogue("You beat him in tic-tac-toe, revealing your captivating smile and laughter when you keep desYORTing him. Oswaldo gets to know you more as a fun person.", Oswaldo.class) );
                        }
                        else{
                            if(difficulty == Difficulty.Easy){
                                affectionMeter += 10;
                                condPart(new Dialogue("Oswaldo wins the game and loved playing with you. He takes great pride in his win against you, implementing this happy memory with you forever.", Oswaldo.class));
                            }
                            else if (difficulty == Difficulty.Normal){
                                affectionMeter+= 5;
                                condPart(new Dialogue("Oswaldo wins the game, but a little too easily. He has a feeling that you intentionally lost, but wonders why you would do this. You've piqued his interest more.", Oswaldo.class) );
                            }
                            else{
                                affectionMeter -= 5;
                                condPart(new Dialogue("Oswaldo wins the game, desYorting you completely. He doesn't like people who lose to him, having his interest in you depleted.", Oswaldo.class));
                            }
                        }
                    }
                    else{
                        if (difficulty == Difficulty.Impossible){ // this comes from a property in Choice
                            rightChoice = false;

                            affectionMeter -= 15;

                            condScene(new Scene(
                                    MiscAssets.backgrounds.get("coJogClass"),
                                    new engine.Character[] {
                                        new Oswaldo(0,0)
                                    }
                                ));

                            condPart(new Dialogue("\"What lack of sincerity,\" he murmurs under his breath. He frowns in displeasure and walks away.", CoJoglianese.class));

                            condPart(new Dialogue("Not feeling up to talking to you, he leaves the room annoyed.", CoJoglianese.class));

                            condPart(new Dialogue("Oswaldo feels offended and a little insulted for you declining to play his favorite game.", Oswaldo.class));
                        }
                        else {

                            condScene(new Scene(
                                    MiscAssets.backgrounds.get("coJogClass"),
                                    new engine.Character[] {
                                        new Oswaldo(0,0)
                                    }
                                ));

                            if(difficulty == Difficulty.Easy){
                                affectionMeter += 15;

                                condScene(new Scene(
                                        MiscAssets.backgrounds.get("hallwaybg"),
                                        new engine.Character[] {
                                            new Oswaldo(0,0)
                                        }
                                    ));

                                condPart(new Dialogue("As the two exit the door, they look at each other and burst into a fit of giggles.", Oswaldo.class));

                                condScene(new Scene(
                                        MiscAssets.backgrounds.get("coJogClass"),
                                        new engine.Character[] {
                                            new Oswaldo(0,0)
                                        }
                                    ));

                                condPart(new Dialogue("\"Sorry, Professor Jog!\" the two yelp. They scramble for their things and scurry out of the class.", Oswaldo.class));

                                condPart(new Dialogue("What are you two doing here so late? Go back home and sleep!", CoJoglianese.class));

                                condPart(new Dialogue("Suddenly the door burst open."));

                                condPart(new Dialogue("He glances at you working very studiously, and a smile arises on his lips. \n He quickly catches himself and turns back to his own work, scribbling furiously.", Oswaldo.class));
                            } else {
                                affectionMeter += 10;

                                condPart(new Dialogue("\"I'm glad to help.\"", Oswaldo.class));

                                condPart(new Dialogue("Once you finished all your work, you thank Oswaldo for his help."));

                                condPart(new Dialogue("Oswaldo nods at your dedication, and continues his own studying.", Oswaldo.class));
                            }

                            condPart(new Dialogue("\"I get it!\" you exclaim happily. Now motivated, you work vigorously on the homework problems.", MainCharacter.class));

                            condPart(new Dialogue("\"Do you know how to solve this problem now?\" he asks after explaining some algebra.", Oswaldo.class));

                            condPart(new Dialogue("Before you know it, the two of you end up studying together Professor Co Jog's classroom."));

                            condPart(new Dialogue("He offers to help with your homework and you gladly take up his offer.", Oswaldo.class));

                        }
                    }
                }
            });

        if((difficulty == Difficulty.Easy 
            || difficulty == difficulty.Normal) && affectionMeter >= 70 
        || (difficulty == Difficulty.Impossible && rightChoice)){

            condScene(new Scene(
                    MiscAssets.backgrounds.get("dance")));

            condPart(
                new EmptyPart()
            );

            condScene(new Scene(
                    MiscAssets.backgrounds.get("danceSit")));

            condPart(
                new EmptyPart()
            );

            condScene(new Scene(
                    MiscAssets.backgrounds.get("choicebg")));

            condPart(new Choice("Go to the dance with Oswaldo or study for finals?", "go to the dance!", "study") {
                    @Override
                    public void doAfter(Game game) {
                        if(choice1Picked){
                            if(difficulty == Difficulty.Easy){
                                affectionMeter += 15;
                            } else if(difficulty == Difficulty.Normal){
                                affectionMeter += 10;
                            }else{
                                affectionMeter +=5;
                            }
                            condScene(new Scene(
                                    MiscAssets.backgrounds.get("dancePartner")));

                            condPart(new Choice("dance with oswaldo?", "yes", "no") {
                                    @Override
                                    public void doAfter(Game game) {
                                        if(choice1Picked){
                                            condScene(new Scene(
                                                    MiscAssets.backgrounds.get("balconybg")));

                                            condPart(new Dialogue("It was a magical moment that you and he will never forget."));

                                            condPart(new Dialogue("You and Oswaldo dance outside on the balcony all night, watching the sun rise the next morning while holding on to each other.", Oswaldo.class));
                                        }
                                        else{
                                            if(difficulty==Difficulty.Easy)
                                            {
                                                condScene(new Scene(
                                                        MiscAssets.backgrounds.get("dancebg"),
                                                        new engine.Character[] {
                                                            new Oswaldo(0,0)
                                                        }
                                                    ));

                                                condPart(new Dialogue("Oswaldo and you eat snacks at the buffet, laughing through conversations. However, you guys are one of the few who aren’t dancing, raising public interest in the relationship you have with Oswaldo.", Oswaldo.class));
                                            }
                                            else if(difficulty==Difficulty.Normal)
                                            {
                                                condScene(new Scene(
                                                        MiscAssets.backgrounds.get("dancebg")));

                                                condPart(new Dialogue("Feeling bored, you decide to leave him and hang out with your other friends. Hurt by your indirect lack of acknowledgement of his presence Oswaldo sits alone on a table in a corner of the room with his head down.", MainCharacter.class));
                                            }
                                            else{
                                                condScene(new Scene(
                                                        MiscAssets.backgrounds.get("dancebg"),
                                                        new engine.Character[] {
                                                            new Oswaldo(0,0)
                                                        }
                                                    ));

                                                condPart(new Dialogue("Oswaldo is hurt by your rejection, feeling it is necessary to dance at such a party. He is ashamed and embarrassed asking you to dance in front of the crowd, leaving the dance with his head low.", MainCharacter.class));
                                            }
                                        }
                                    }
                                });

                            condScene(new Scene(
                                    MiscAssets.backgrounds.get("choicebg")));

                            condPart(new Choice("what will you wear?", "green dress", "guy suit", "school uniform") {
                                    @Override
                                    public void doAfter(Game game) {
                                        if(choice1Picked){
                                            if(difficulty == Difficulty.Easy){
                                                affectionMeter += 15;
                                            } else if(difficulty == Difficulty.Normal){
                                                affectionMeter += 10;
                                            }else{
                                                affectionMeter +=5;
                                            }
                                            condScene(new Scene(
                                                    MiscAssets.backgrounds.get("greendressbg")));

                                            condPart(new Dialogue("He feels allured by your sophistication, thus leaving him with more confirmation that you are the right person for him.", MainCharacter.class));
                                        }   
                                        else if(choice2Picked){
                                            if(difficulty == Difficulty.Easy){
                                                affectionMeter += 15;
                                            } else if(difficulty == Difficulty.Normal){
                                                affectionMeter += 10;
                                            }else{
                                                affectionMeter +=5;
                                            }
                                            condScene(new Scene(
                                                    MiscAssets.backgrounds.get("suitbg")));

                                            condPart(new Dialogue("He feels allured by your sophistication, thus leaving him with more confirmation that you are the right person for him.", MainCharacter.class));
                                        }
                                        else{
                                            if(difficulty == Difficulty.Normal){
                                                affectionMeter -= 10;
                                            }else{
                                                affectionMeter -=20;
                                                rightChoice = false;
                                            }

                                            condScene(new Scene(
                                                    MiscAssets.backgrounds.get("schooluniformbg")));

                                            condPart(new Dialogue("Oswaldo feels slightly awkward and embarassed about taking you out to the dance.", MainCharacter.class));
                                        }  
                                    }
                                });

                            condScene(new Scene(
                                    MiscAssets.backgrounds.get("outfitSit")));

                            condPart(
                                new EmptyPart()
                            );

                        }
                        else if (choice2Picked){
                            if(difficulty == Difficulty.Impossible){
                                affectionMeter -= 20;
                                rightChoice = false;
                            } else if(difficulty == Difficulty.Normal){
                                affectionMeter -= 10;
                            }
                            condScene(new Scene(
                                    MiscAssets.backgrounds.get("hallwaybg"),
                                    new engine.Character[] {
                                        new Oswaldo(0,0)
                                    }
                                ));

                            condPart(new Dialogue("Oswaldo's heart tore a little at the rejection and he slowly turned away once the classroom door shut closed.", Oswaldo.class) );
                            condScene(new Scene(
                                    MiscAssets.backgrounds.get("coJogClass")));

                            condPart(new Dialogue("Although it pained you to reject Oswaldo, you left him to watch your figure gradually disappear back into Professor CoJoglianese's classroom to study the night.", MainCharacter.class));

                        }  
                    }
                });
        }
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
                                MiscAssets.backgrounds.get("graduationbg"),
                                new engine.Character[] {
                                    new Oswaldo(0,0)
                                }
                            ));

                        condPart(new Dialogue("No problem, I’m always here to help! Thank you for all your hard work as well.” Oswaldo replies to your formal congratulation. He has a feeling that you have friendzoned him, hurting his pride, but having to hold up his reputation as the Duke of Yort, Oswaldo shows no emotion that would indicate that he was hurt by your words. ", MainCharacter.class) {
                                @Override
                                public void doAfter(Game game) {
                                    // could change emotion of characters or something
                                }
                            });
                    }
                    else if(choice3Picked){
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("graduationbg"),
                                new engine.Character[] {
                                    new Oswaldo(0,0)
                                }
                            ));

                        condPart(new Dialogue("Oswaldo glances at you, but doesn’t take the initiative to talk to you. He feels a barrier between him and you, not having enough interest to cross the distance towards you.", MainCharacter.class) {
                                @Override
                                public void doAfter(Game game) {
                                    // could change emotion of characters or something
                                }
                            });
                    }
                    else{
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("graduationbg"),
                                new engine.Character[] {
                                    new Oswaldo(0,0)
                                }
                            ));

                        condPart(
                            new FullScreenMessage(
                                MiscAssets.generateConfession(MainCharacter.name)
                            )
                        );
                    }
                }
            });

        addScene(new Scene(
                MiscAssets.backgrounds.get("endScene")));

        addPart(
            new EmptyPart() {
                @Override
                public void doAfter(Game game) {
                    if(affectionMeter >= 100 || (difficulty == Difficulty.Impossible && rightChoice == true)){
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("marriageSit")));

                        condPart(
                            new EmptyPart()
                        );

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("choicebg")));

                        condPart(new Choice("say yes?", "yes", "no") {
                                @Override
                                public void doAfter(Game game) {
                                    if(choice1Picked){
                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("churchbg"),
                                                new engine.Character[] {
                                                    new Oswaldo(0,0)
                                                }
                                            ));

                                        condPart(new Dialogue("Church bells ring as the priest asks, “Do you take the Duke of Yort, Oswaldo, to be your lawfully wedded husband?” You happily say 'yes' and become married, living happily ever after with three cats and two dogs, as well as five ducks. ", MainCharacter.class));

                                    }
                                    else{
                                        if(Difficulty.Normal == difficulty || difficulty == Difficulty.Easy){
                                            condScene(new Scene(
                                                    MiscAssets.backgrounds.get("choicebg")));

                                            condPart(new Choice("change your mind?", "yes", "no") {
                                                    @Override
                                                    public void doAfter(Game game) {
                                                        if(choice1Picked){
                                                            condScene(new Scene(
                                                                    MiscAssets.backgrounds.get("churchbg"),
                                                                    new engine.Character[] {
                                                                        new Oswaldo(0,0)
                                                                    }
                                                                ));

                                                            condPart(new Dialogue("Church bells ring as the priest asks, “Do you take the Duke of Yort, Oswaldo, to be your lawfully wedded husband?” You happily say 'yes' and become married, living happily ever after with three cats and two dogs, as well as five ducks. ", MainCharacter.class)); 
                                                        }
                                                        else{
                                                            condScene(new Scene(
                                                                    MiscAssets.backgrounds.get("freedombg")));

                                                            condPart(new Dialogue("You chose to be free and live solo", MainCharacter.class));
                                                        }
                                                    }
                                                });   

                                            condScene(new Scene(
                                                    MiscAssets.backgrounds.get("bedroom"),
                                                    new engine.Character[] {
                                                        new Oswaldo(0,0)
                                                    }
                                                ));

                                            condPart(new Dialogue("He puts the ring back in his pocket and gets up from the floor dejectedly. Oswaldo, not looking at you at all, turns away heartbroken. Before he leaves the door, you have final decision to make...", Oswaldo.class));
                                        }else{
                                            condScene(new Scene(
                                                    MiscAssets.backgrounds.get("ripbg")));

                                            condPart(
                                                new FullScreenMessage(
                                                    MiscAssets.generateBackgroundInfo(MainCharacter.name)
                                                )
                                            );
                                        }

                                    }
                                }
                            });
                    }else if(rightChoice == false){
                        addScene(new Scene(
                                MiscAssets.backgrounds.get("ripbg")));

                        condPart(
                            new FullScreenMessage(
                                MiscAssets.generateBackgroundInfo(MainCharacter.name)
                            )
                        );
                    }else{
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("freedombg")));

                        condPart(new Dialogue("You chose to be free and live solo", MainCharacter.class));
                    }
                }
            }
        );

        addScene(new Scene(
                MiscAssets.backgrounds.get("endbg")));

        addPart(
            new EmptyPart()
        );

        addScene(new Scene(
                MiscAssets.backgrounds.get("credits")));

        addPart(
            new EmptyPart()
        );
        // example scene for y'all to see how to do

        // adds scene with bg of "bedroom"
        //addScene(new Scene(
        //        MiscAssets.backgrounds.get("bedroom"),
        //        new engine.Character[] {
        //            new Oswaldo(0,0),
        //            new BoJiden(50, 50)
        //        }
        //    ));

        // example of how to do difficulty specific stuff
        /*if (difficulty == Difficulty.Impossible) {
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
         */
    }
    // only needed cuz of type erasure, so i
    // cant override generics in the way i want to
    private YortData data(Game game) {
        return (YortData)game.getData();
    }
}
