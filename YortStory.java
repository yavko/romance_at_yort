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
    public boolean dating = false;
    public YortStory(Difficulty defaultDifficulty) {
        super();
        this.difficulty = defaultDifficulty;
        // PLACEGHOLDER PLZ FIX LATER YES

        MainCharacter.name = "placeholder";

        // story logic

        Clip mainTheme = engine.MediaPlayer.createClip("./audio/Main theme.wav", true);
        // User enters their name and will be inputted in the background context.
        addScene(new Scene(
                MiscAssets.backgrounds.get("base")));   

        addPart(new NullPart(){
                @Override
                public void doAfter(Game game){
                    mainTheme.start();
                }
            });

        addPart(new Input("Please enter your name: ") {
                @Override
                public void doAfter(Game game) {

                    System.out.println("chosen name: " + inputtedText);
                    MainCharacter.name = inputtedText;
                }
            });
        // Start screen
        addPart(
            new FullScreenMessage(() -> MiscAssets.generateBackgroundInfo(MainCharacter.name)
            )
        );

        addScene(new Scene(
                MiscAssets.backgrounds.get("bgPt2")));

        addPart(
            new FullScreenMessage(() ->
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
            new FullScreenMessage(() ->
                    MiscAssets.generateWelcomeText(MainCharacter.name)
            )
        );

        addScene(new Scene(
                MiscAssets.backgrounds.get("introDiff"))
        );
        addPart(new Choice(" ", "Easy", "Normal", "Impossible") {
                @Override
                public void doAfter(Game game) {
                    if (choice1Picked)
                        difficulty = Difficulty.Easy;
                    else if (choice2Picked)
                        difficulty = Difficulty.Normal;
                    else
                        difficulty = Difficulty.Impossible;
                }
            });
        // Brrrway meeting: First meeting between Oswaldo and the user in which the user has up to 3 choices to choose from.

        Clip breezeway= engine.MediaPlayer.createClip("./audio/breezeway.wav", true);

        addScene(new Scene(
                MiscAssets.backgrounds.get("brrrwayMeeting")));

        addPart(
            new EmptyPart(){
                @Override
                public void doAfter(Game game){
                    mainTheme.stop();

                    breezeway.start();
                }
            }
        );

        addScene(new Scene(
                MiscAssets.backgrounds.get("brrrwaySit")));

        addPart(
            new EmptyPart()
        );

        addScene(new Scene(
                MiscAssets.backgrounds.get("choicebg")));

        addPart(new Choice("What do you do?", "Be nice and introduce yourself: \"Oh, I’m so sorry! I didn’t see you there.\"", "Be rude and lash out: \"Hey, watch where you're going! Some of us are trying to go to class.\"", "Be mysterious and whip those luscious locks!!" ) {
                @Override
                public void doAfter(Game game) {
                    if (choice1Picked){ // User chooses the good option
                        Clip goodResponse1 = engine.MediaPlayer.createClip("./audio/GooderResponse1.wav", true);
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("choicebg")
                            ));

                        condPart(new Choice("How do you start the conversation?", "\"So, what do you like to do for fun? I’m really into photography. I love capturing moments.\"", "\"I’ve been wanting to check out the new art exhibit. Want to come with me this weekend?\"", "\"Do you believe in love at first sight, or should I walk by again?\"") {
                                @Override
                                public void doAfter(Game game) {
                                    // Secret scene if they chose option 1 from the brrrway scene
                                    Clip cafe = engine.MediaPlayer.createClip("./audio/HangoutPostBrzway.wav", true);

                                    condScene(new Scene(
                                            MiscAssets.backgrounds.get("cafebg"),
                                            new engine.Character[] {
                                                new Oswaldo(0,0)
                                            }
                                        ));
                                    if(choice1Picked){
                                        condPart(new EmptyPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    cafe.stop();
                                                }
                                            });

                                        condPart(new Dialogue("He lights up and shares that he enjoys playing guitar. As you talk, he mentions he’s performing at the school talent show next week. You decide to support him and plan to attend the show together. Oswaldo feels appreciated and has a good impression of you."));

                                        condPart(new NullPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    goodResponse1.stop();
                                                    cafe.start();
                                                }
                                            });
                                        if(difficulty == Difficulty.Easy){
                                            affectionMeter += 5;
                                        } else if(difficulty == Difficulty.Normal){
                                            affectionMeter += 3;
                                        }
                                        else{
                                            affectionMeter +=1;
                                        }
                                    }
                                    else if(choice2Picked){
                                        condPart(new EmptyPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    cafe.stop();
                                                }
                                            });
                                        condPart(new Dialogue("Oswaldo hasn’t had a good laugh in a while and has a good impression of you."));

                                        condPart(new Dialogue("He notices and says,\"Seems like we’ve caught some attention. Want to give them something to talk about?\" You both laugh and decide to take a fun selfie together."));  

                                        condPart(new Dialogue("As you chat, you notice a few classmates whispering and pointing."));

                                        condPart(new Dialogue("\"That sounds amazing! I’ve heard great things about it. Let’s make it a plan!\""));

                                        condPart(new NullPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    goodResponse1.stop();
                                                    cafe.start();
                                                }
                                            });
                                        if(difficulty == Difficulty.Easy){
                                            affectionMeter += 5;
                                        } else if(difficulty == Difficulty.Normal){
                                            affectionMeter += 3;
                                        }
                                        else{
                                            affectionMeter +=1;
                                        }
                                    }else{
                                        condPart(new EmptyPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    cafe.stop();
                                                }
                                            });
                                        condPart(new Dialogue("You both head back to school, where you sit together in the cafeteria. The playful banter continues, and you challenge each other to a game of “Two Truths and a Lie,” revealing surprising truths about yourselves. You leave a humorous and fun impression on Oswaldo."));

                                        condPart(new Dialogue("He laughs, clearly amused. \"Well, you’ve definitely caught my attention. Let’s see if you can keep it.\""));

                                        condPart(new NullPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    goodResponse1.stop();
                                                    goodResponse1.close();
                                                    cafe.start();
                                                }
                                            });
                                        if(difficulty == Difficulty.Easy){
                                            affectionMeter += 5;
                                        } else if(difficulty == Difficulty.Normal){
                                            affectionMeter += 3;
                                        }
                                        else{
                                            affectionMeter +=1;
                                        }
                                    }
                                }
                            });
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("hallwaybg"),
                                new engine.Character[] {
                                    new Oswaldo(0,0)
                                }
                            ));
                        condPart(new Dialogue("After school, you both head to the nearby cafe. As you sit down, you notice a group of your classmates walk in and glance over."));

                        condPart(new Dialogue("The two stood in silence, but you hope he didn't hear your thumping heart. After a few seconds, he suggests grabbing coffee."));

                        condPart(new Dialogue("\"Hey, no worries at all! It was an accident. I’m sure you didn’t mean to. My name is Oswaldo,\" he smiles warmly."));

                        condPart(new NullPart(){
                                @Override
                                public void doAfter(Game game){
                                    breezeway.stop();
                                    goodResponse1.start();
                                }
                            });

                        if(difficulty == Difficulty.Easy){
                            affectionMeter += 15;
                        } else if(difficulty == Difficulty.Normal){
                            affectionMeter += 10;
                        }
                        else{
                            affectionMeter +=5;
                        }
                    } else if(choice2Picked){ // User chooses the bad option out of the bunch
                        rightChoice = false;
                        Clip BadResponse1 = engine.MediaPlayer.createClip("./audio/BadResponse1.wav", true);

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("choicebg")
                            ));
                        condPart(new Choice("What should you say?", "\"Wait, I didn’t mean it like that. Can we start over?\"", "\"Whatever, it’s not like I care. I have places to be.\"", "\"Maybe I was just testing your reaction. What's your next move?\"") {
                                @Override
                                public void doAfter(Game game){
                                    condScene(new Scene(
                                            MiscAssets.backgrounds.get("hallwaybg"),
                                            new engine.Character[] {
                                                new Oswaldo(0,0)
                                            }
                                        ));
                                    // User gets to choose another 3 choices based on their rude response
                                    if(choice1Picked){
                                        condPart( new Dialogue("You both head to class together, and during a group project, you find yourselves paired up. As you work, you realize he’s actually pretty cool, and you start to enjoy his company. However, you notice that he is still cautious of you."));

                                        condPart(new Dialogue("He turns back, a cautious smile on his face. \"Sure, I’m Oswaldo. Let’s pretend I didn’t just get insulted.\""));
                                        condPart(new EmptyPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    BadResponse1.stop();
                                                }
                                            });
                                    }
                                    else if(choice2Picked){
                                        condPart(new NullPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    BadResponse1.stop();
                                                }
                                            });

                                        condPart(new Dialogue("You left a bad impression on him."));
                                        condPart(new Dialogue("He walks away, and as you sit in class, you can’t help but feel a bit guilty. Later, during lunch, you overhear him talking to friends about how he prefers people who are genuine."));
                                        condPart(new Dialogue("He raises an eyebrow, clearly unimpressed. \"Alright then. Good luck with your busy schedule.\""));

                                        if(difficulty == Difficulty.Normal){
                                            affectionMeter -= 5;
                                        }
                                        else{
                                            affectionMeter -= 10;
                                        }
                                    }else{
                                        condPart(new Dialogue("Intrigued by your boldness, Oswaldo stays to chat. You both end up sitting together at lunch, where he challenges you to a debate about school rules, and surprisingly, you find you have similar views. However, he is still suspicious of your behavior."));
                                        condPart(new Dialogue("He smirks. \"Well, if that was a test, I’d say I passed. What’s your real story?\""));
                                        if(difficulty == Difficulty.Easy){
                                            affectionMeter += 5;
                                        } else if(difficulty == Difficulty.Normal){
                                            affectionMeter += 3;
                                        }
                                        else{
                                            affectionMeter +=1;
                                        }
                                        condPart(new NullPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    BadResponse1.stop();
                                                }
                                            });
                                    }
                                }
                            });
                        if(difficulty == Difficulty.Normal){
                            affectionMeter -= 5;
                        }else if(difficulty == Difficulty.Impossible){
                            affectionMeter -= 20;
                        }
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("hallwaybg"),
                                new engine.Character[] {
                                    new Oswaldo(0,0)
                                }
                            ));
                        condPart(new Dialogue("Oswaldo, the guy you bumped into, looks taken aback and shakes his head slightly. \"That’s a bit harsh, don’t you think? It was just an accident.\" He turns to walk away, but you notice he hesitates."));

                        condPart(new NullPart(){
                                @Override
                                public void doAfter(Game game){
                                    breezeway.stop();
                                    BadResponse1.start();
                                }
                            });
                    } else{

                        Clip goodResponse2 = engine.MediaPlayer.createClip("./audio/GooderResponse2.wav", true);

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("choicebg")
                            ));
                        condPart(new Choice("Now's the chance. What do you do?", "Whip your luscious locks once again and walk past him with flair.", "You flash a smile and stay coy while also saying nothing once again.") {
                                @Override
                                public void doAfter(Game game){
                                    condScene(new Scene(
                                            MiscAssets.backgrounds.get("hallwaybg"),
                                            new engine.Character[] {
                                                new Oswaldo(0,0)
                                            }
                                        ));
                                    // User gets to choose between 2 options based on their mysterious choice
                                    if(choice1Picked){
                                        condPart(new EmptyPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    goodResponse2.stop();
                                                }
                                            });
                                        condPart(new Dialogue("\"Wow,\" he says softly, almost to himself, as you walk past. You glance back just in time to see him shake his head. You’ve piqued his intrest, but Oswaldo is a bit hurt with you not apologizing."));
                                        condPart(new Dialogue("As you toss your hair back dramatically, you feel the eyes of the hallway on you. The movement is fluid, confident, and you can’t help but feel a rush of empowerment. You stride away, but you can’t shake the feeling that he’s still watching you."));
                                        if(difficulty == Difficulty.Easy){
                                            affectionMeter += 5;
                                        } else if(difficulty == Difficulty.Normal){
                                            affectionMeter += 3;
                                        }
                                        else{
                                            affectionMeter +=1;
                                        }
                                    }
                                    else{
                                        condPart(new NullPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    goodResponse2.stop();
                                                    goodResponse2.close();
                                                }
                                            });
                                        condPart(new Dialogue("\"Wow, a woman of few words, huh? I like that,\" he mutters as you walk past him to your next class. Oswaldo becomes a bit interested in you, but his interest is still similar to as if you were a normal person passing him by."));

                                        condPart(new Dialogue("He raises an eyebrow, clearly intrigued by your silent confidence."));
                                        if(difficulty == Difficulty.Easy){
                                            affectionMeter += 5;
                                        } else if(difficulty == Difficulty.Normal){
                                            affectionMeter += 3;
                                        }
                                        else{
                                            affectionMeter +=1;
                                        }
                                    }
                                }
                            });
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("hallwaybg"),
                                new engine.Character[] {
                                    new Oswaldo(0,0)
                                }
                            ));

                        condPart(new Dialogue("The guy you bumped into was Oswaldo. He looks at you as if waiting for you to say something, but you don’t."));

                        condPart(new NullPart(){
                                @Override
                                public void doAfter(Game game){
                                    breezeway.stop();
                                    breezeway.close();
                                    goodResponse2.start();
                                }
                            });

                        if(difficulty == Difficulty.Normal){
                            affectionMeter -=5;
                        }else if(difficulty == Difficulty.Impossible){
                            affectionMeter -= 10;
                        }
                    }
                }
            });

        Clip ticTacToe= engine.MediaPlayer.createClip("./audio/ticTacToe.wav", true);

        addScene(new
            Scene(
                MiscAssets.backgrounds.get("ticTacToe")));

        addPart(new EmptyPart(){
                @Override
                public void doAfter(Game game){
                    breezeway.stop();
                    ticTacToe.start();
                }
            });

        addScene(new 
            Scene(
                MiscAssets.backgrounds.get("tttSit")));
        addPart(
            new EmptyPart()
        );

        addScene(new 
            Scene(
                MiscAssets.backgrounds.get("choicebg")));

        addPart(new            
            Choice("Will you play Tic Tac Toe", "yes", "no") {
                @Override
                public void doAfter(Game game) {
                    if (choice1Picked){ // this comes from a property in Choice

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("tttbg")));

                        if(true)
                        {
                            if(difficulty == Difficulty.Easy){
                                affectionMeter += 15;
                            } else if(difficulty == Difficulty.Normal){
                                affectionMeter += 10;
                            }else{
                                affectionMeter +=1;
                            }

                            condPart(new Dialogue("You beat him in tic-tac-toe, revealing your captivating smile and laughter when you keep desYORTing him. Oswaldo gets to know you more as a fun person.") );
                        }
                        else{
                            if(difficulty == Difficulty.Easy){
                                affectionMeter += 10;
                                condPart(new Dialogue("Oswaldo wins the game and loved playing with you. He takes great pride in his win against you, implementing this happy memory with you forever."));
                            }
                            else if (difficulty == Difficulty.Normal){
                                affectionMeter+= 5;
                                condPart(new Dialogue("Oswaldo wins the game, but a little too easily. He has a feeling that you intentionally lost, but wonders why you would do this. You've piqued his interest more.") );
                            }
                            else{
                                affectionMeter -= 5;
                                condPart(new Dialogue("Oswaldo wins the game, desYorting you completely. He doesn't like people who lose to him, having his interest in you depleted."));
                            }
                        }

                        condPart(new TicTacToe(difficulty.asMinigameDifficulty()) {
                                @Override
                                public void doAfter(Game game) {

                                }
                            });
                    }
                    else{
                        if (difficulty == Difficulty.Impossible){ // this comes from a property in Choice
                            Clip badResponse2 = engine.MediaPlayer.createClip("./audio/BadResponse2.wav", true);

                            rightChoice = false;

                            affectionMeter -= 15;

                            condScene(new Scene(
                                    MiscAssets.backgrounds.get("tttbg"),
                                    new engine.Character[] {
                                        new Oswaldo(0,0)
                                    }
                                ));
                            condPart(new EmptyPart(){
                                    @Override
                                    public void doAfter(Game game){
                                        badResponse2.stop();
                                    }
                                });
                            condPart(new Dialogue("\"What lack of sincerity,\" he murmurs under his breath. He frowns in displeasure and walks away."));

                            condPart(new Dialogue("Not feeling up to talking to you, he leaves the room annoyed."));

                            condPart(new Dialogue("Oswaldo feels offended and a little insulted for you declining to play his favorite game."));

                            condPart(new NullPart(){
                                    @Override
                                    public void doAfter(Game game){
                                        ticTacToe.stop();
                                        badResponse2.start();
                                    }
                                });
                        }
                        else {

                            condScene(new Scene(
                                    MiscAssets.backgrounds.get("tttbg"),
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

                                condPart(new Dialogue("As the two exit the door, they look at each other and burst into a fit of giggles."));

                                condScene(new Scene(
                                        MiscAssets.backgrounds.get("tttbg"),
                                        new engine.Character[] {
                                            new Oswaldo(0,0)
                                        }
                                    ));

                                condPart(new Dialogue("\"Sorry, Professor Jog!\" the two yelp. They scramble for their things and scurry out of the class."));

                                condScene(new Scene(
                                        MiscAssets.backgrounds.get("tttbg"),
                                        new engine.Character[] {
                                            new CoJoglianese(0,0)
                                        }
                                    ));

                                condPart(new Dialogue("What are you two doing here so late? Go back home and sleep!"));

                                condScene(new Scene(
                                        MiscAssets.backgrounds.get("tttbg")
                                    ));

                                condPart(new Dialogue("Suddenly the door burst open."));
                                condPart(new Dialogue("He glances at you working very studiously, and a smile arises on his lips. \n He quickly catches himself and turns back to his own work, scribbling furiously."));
                            } else {
                                affectionMeter += 10;

                                condPart(new Dialogue("\"I'm glad to help.\""));

                                condPart(new Dialogue("Once you finished all your work, you thank Oswaldo for his help."));

                                condPart(new Dialogue("Oswaldo nods at your dedication, and continues his own studying."));
                            }

                            condPart(new Dialogue("\"I get it!\" you exclaim happily. Now motivated, you work vigorously on the homework problems."));

                            condPart(new Dialogue("\"Do you know how to solve this problem now?\" he asks after explaining some algebra."));

                            condPart(new Dialogue("Before you know it, the two of you end up studying together Professor Co Jog's classroom."));

                            condPart(new Dialogue("He offers to help with your homework and you gladly take up his offer."));

                        }
                    }
                }
            });

        Clip awkward= engine.MediaPlayer.createClip("./audio/AwkwardEncounter.wav", true);

        addScene(new Scene(
                MiscAssets.backgrounds.get("awkward")
            ));

        addPart(new NullPart(){
                @Override
                public void doAfter(Game game){
                    ticTacToe.stop();
                    awkward.start();
                }
            });

        addScene(new Scene(MiscAssets.backgrounds.get("awkwardSit")
            ));

        addPart(
            new 
            EmptyPart()
        );

        addScene(new Scene(
                MiscAssets.backgrounds.get("choicebg")
            ));

        addPart(new 
                // Secret Scene with school incident and deciding if you see Oswaldo as your potential partner
            Choice("What do you do?", "Blush and say nothing.", "Tell your friend that you guys are not together and leave Oswaldo.", "Pretend like you guys are together and reach for Oswaldo’s hand.") {
                @Override
                public void doAfter(Game game) {
                    if(choice1Picked){

                        if(difficulty == Difficulty.Easy){
                            affectionMeter += 15;
                        }else if(difficulty == Difficulty.Normal){
                            affectionMeter +=10;
                        }else{
                            affectionMeter +=5;
                        }
                        Clip goodResponse2= engine.MediaPlayer.createClip("./audio/GooderResponse2.wav", true);

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("schoolbg")
                            ));
                        condPart(new NullPart(){
                                @Override
                                public void doAfter(Game game){
                                    goodResponse2.stop();

                                }
                            });
                        condPart(new Dialogue("\"I don't mind,\" you say very quietly."));

                        condPart(new Dialogue("Oswaldo looks hopefully at you. Once your friend is out of sight he stands closer to you and apologizes for his previous behavior."));

                        condPart(new NullPart(){
                                @Override
                                public void doAfter(Game game){
                                    awkward.stop();
                                    goodResponse2.start();
                                }
                            });
                    } else if(choice2Picked){
                        Clip badResponse2= engine.MediaPlayer.createClip("./audio/BadResponse2.wav", true);

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("schoolbg")
                            ));

                        if(difficulty == Difficulty.Normal){    
                            affectionMeter -= 5;
                            condPart(new NullPart(){
                                    @Override
                                    public void doAfter(Game game){
                                        awkward.stop();
                                        badResponse2.start();
                                    }
                                });
                            condPart(new Dialogue("You thought that Oswaldo would have pretended that nothing happened, but it's been a whole month since you've seen him."));

                            condPart(new Dialogue("Oswaldo looks after you in despair. Any hope he had of fixing the relationship has just been diminished into dust. Head down low, he walks away from the shame of your rejection."));
                            condPart(new NullPart(){
                                    @Override
                                    public void doAfter(Game game){
                                        awkward.stop();
                                        badResponse2.start();
                                    }
                                });
                        }else if(difficulty == Difficulty.Impossible){
                            condPart(new NullPart(){
                                    @Override
                                    public void doAfter(Game game){
                                        awkward.stop();
                                        badResponse2.start();
                                    }
                                });
                            condPart(new Dialogue("Oswaldo is disappointed by your behavior. He makes a mental note to never speak to you again. He leaves, and you stare after him heartbroken."));
                            condPart(new NullPart(){
                                    @Override
                                    public void doAfter(Game game){
                                        awkward.stop();
                                        badResponse2.start();
                                    }
                                });
                            affectionMeter -=20;
                        }else{
                            condPart(new Dialogue("After you left, Oswalso chased after you. \n \"Are you okay. I'm sorry about those guys making jokes like that.\""));
                        }

                    }else{
                        Clip goodResponse1 = engine.MediaPlayer.createClip("./audio/GooderResponse1.wav", true);
                        Clip badResponse3= engine.MediaPlayer.createClip("./audio/BadResponse3.wav", true);

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("schoolbg")
                            ));
                        if(difficulty == Difficulty.Easy || (difficulty == Difficulty.Impossible && rightChoice == true)){
                            condPart(new EmptyPart(){
                                    @Override
                                    public void doAfter(Game game){
                                        goodResponse1.stop();

                                    }
                                });
                            condPart(new Dialogue("\"Nothing.\" he says covering his face with his other hand. His friends whisper between each other snickering at Oswaldo's flushed faced."));
                            condPart(new Dialogue("\"What's wrong?\" you ask."));
                            condPart(new Dialogue("Oswaldo turned a bright shade of pink at the touch of your hand."));

                            condPart(new EmptyPart(){
                                    @Override
                                    public void doAfter(Game game){
                                        awkward.stop();
                                        goodResponse1.start();
                                    }
                                });

                            if(difficulty == Difficulty.Easy){
                                affectionMeter += 15;
                            }else if(difficulty == Difficulty.Impossible){
                                affectionMeter +=5;
                            }
                        }else if(difficulty == Difficulty.Normal && affectionMeter >= 70){
                            affectionMeter += 5;
                            condPart(new EmptyPart(){
                                    @Override
                                    public void doAfter(Game game){
                                        goodResponse1.stop();
                                    }
                                });
                            condPart(new Dialogue("Oswaldo looks at your interlocked hands, and a pink hue rises to his face."));
                            condPart(new EmptyPart(){
                                    @Override
                                    public void doAfter(Game game){
                                        awkward.stop();
                                        goodResponse1.start();
                                    }
                                });
                        }else if(difficulty == Difficulty.Normal){
                            affectionMeter -= 5;
                            condPart(new EmptyPart(){
                                    @Override
                                    public void doAfter(Game game){
                                        badResponse3.stop();
                                    }
                                });
                            condPart(new Dialogue("Oswaldo looks at your interlocked hands with a weird expression and slowly pulls away. He doesn't think that you're close enough to do that"));
                            condPart(new EmptyPart(){
                                    @Override
                                    public void doAfter(Game game){
                                        awkward.stop();
                                        badResponse3.start();
                                    }
                                });

                        }else{
                            affectionMeter -= 20;
                            condPart(new EmptyPart(){
                                    @Override
                                    public void doAfter(Game game){
                                        badResponse3.stop();
                                    }
                                });
                            condPart(new Dialogue("Oswaldo snatches his hands away and looks at you in disgust. \n \"I didn't give you permission to touch me\""));
                            condPart(new EmptyPart(){
                                    @Override
                                    public void doAfter(Game game){
                                        awkward.stop();
                                        badResponse3.start();
                                    }
                                });
                        }

                    }
                }
            });

        Clip dance = engine.MediaPlayer.createClip("./audio/ballroomDance.wav", true);

        addScene(new Scene(
                MiscAssets.backgrounds.get("dance")));

        addPart(new NullPart(){
                @Override
                public void doAfter(Game game){
                    awkward.stop();
                    dance.start();
                }
            });
        //change to nullPart or something else
        addPart(
            new NullPart(){
                @Override
                public void doAfter(Game game) {
                    if((difficulty != Difficulty.Impossible) && affectionMeter >= 70 
                    || (difficulty == Difficulty.Impossible && rightChoice)){
                        Clip crush = engine.MediaPlayer.createClip("./audio/5thGradeCrush.wav", true);
                        Clip goodResponse1 = engine.MediaPlayer.createClip("./audio/GooderResponse1.wav", true);
                        Clip badResponse1 = engine.MediaPlayer.createClip("./audio/BadResponse1.wav", true);
                        Clip eating = engine.MediaPlayer.createClip("./audio/eatingScene.wav", true);

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("choicebg")));
                        // User will decide with going to the dance or studying. 
                        condPart(new Choice("Go to the dance or study for finals?", "go to the dance!", "study") {
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

                                        condScene(new 
                                            Scene(
                                                MiscAssets.backgrounds.get("dancePartner")));

                                        condScene(new 
                                            Scene(
                                                MiscAssets.backgrounds.get("danceSit")));

                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("choicebg")));

                                        condPart(new Choice("dance with oswaldo?", "yes", "no") {
                                                @Override
                                                public void doAfter(Game game) {

                                                    if(choice1Picked){
                                                        // Secret scene with the user's past crush at the dance
                                                        //call game here

                                                        condScene(new Scene(
                                                                MiscAssets.backgrounds.get("crushSit")));

                                                        condScene(new 
                                                            Scene(
                                                                MiscAssets.backgrounds.get("choicebg")));

                                                        condPart(
                                                            new Choice("what do you do?", "What's the harm? You accept and you dance togther, chatting and catching up on the past few years.", "You decline politely, deciding to wait for Oswaldo to come back."){
                                                                @Override
                                                                public void doAfter(Game game) {
                                                                    if(choice1Picked){
                                                                        condScene(new Scene(
                                                                                MiscAssets.backgrounds.get("dancebg"),
                                                                                new engine.Character[] {
                                                                                    new Oswaldo(0,0)
                                                                                }));
                                                                        if(difficulty == Difficulty.Normal){        
                                                                            condPart(new NullPart(){
                                                                                    @Override
                                                                                    public void doAfter(Game game){
                                                                                        badResponse1.stop();
                                                                                    }
                                                                                });
                                                                            condPart(new Dialogue("Disheartened by your actions, he turns away."));
                                                                            condPart(new NullPart(){
                                                                                    @Override
                                                                                    public void doAfter(Game game){
                                                                                        crush.stop();
                                                                                        badResponse1.start();
                                                                                    }
                                                                                });
                                                                        }else if(difficulty == Difficulty.Impossible){
                                                                            condPart(new NullPart(){
                                                                                    @Override
                                                                                    public void doAfter(Game game){
                                                                                        badResponse1.stop();
                                                                                    }
                                                                                });
                                                                            condPart(new Dialogue("He looks at you with a face of betrayal and swiftly leaves. Whatever magic happened at the balconey had disappeared after midnight."));
                                                                            condPart(new Dialogue("Oswaldo comes storming towards you and your 5th grade crush. Out of anger, he thrusts the cup of juice at you and your crush."));
                                                                            condPart(new NullPart(){
                                                                                    @Override
                                                                                    public void doAfter(Game game){
                                                                                        crush.stop();
                                                                                        badResponse1.start();
                                                                                    }
                                                                                });
                                                                        }else{

                                                                            condPart(new Dialogue("\"She's mine.\" Not yours."));
                                                                            condPart(new Dialogue("\"Get of of here, before I have my father ban you from ever stepping foot here again.\""));
                                                                        }
                                                                        condScene(new Scene(
                                                                                MiscAssets.backgrounds.get("dancebg")));

                                                                        condPart(new Dialogue("Little did you know, Oswaldo had seen the guy approach you as he was coming back to get the drinks."));
                                                                    }else{
                                                                        condPart(new NullPart(){
                                                                                @Override
                                                                                public void doAfter(Game game){
                                                                                    crush.stop();

                                                                                }
                                                                            });
                                                                        condScene(new Scene(
                                                                                MiscAssets.backgrounds.get("dancebg")));
                                                                        condPart(new Dialogue("\"For you,\" he said. You take the glass and the two of you sip the glass together in peace."));
                                                                        condPart(new Dialogue("You said goodbye to your old crush, and wait patiently for Oswaldo. After a few minutes of watching the other couples dance, Oswaldo comes back with two drinks in his hand."));
                                                                    }
                                                                }
                                                            });
                                                        condScene(new Scene(
                                                                MiscAssets.backgrounds.get("crush")));

                                                        condPart(new NullPart(){
                                                                @Override
                                                                public void doAfter(Game game){
                                                                    dance.stop();
                                                                    crush.start();

                                                                }
                                                            });
                                                        condScene(new Scene(
                                                                MiscAssets.backgrounds.get("balconybg")));

                                                        condPart(new Dialogue("It was a magical moment that you two will never forget..."));

                                                        condPart(new Dialogue("You and Oswaldo dance outside on the balcony all night, watching the sun rise the next morning while holding on to each other."));

                                                        condPart(new DanceGame(difficulty.asMinigameDifficulty()) {
                                                                @Override
                                                                public void doAfter(Game game) {

                                                                }
                                                            });
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
                                                            condPart(new NullPart(){
                                                                    @Override
                                                                    public void doAfter(Game game){
                                                                        eating.stop();
                                                                    }
                                                                });
                                                            condPart(new Dialogue("Oswaldo and you eat snacks at the buffet, laughing through conversations. However, you guys are one of the few who aren’t dancing, raising public interest in the relationship you have with Oswaldo."));
                                                            condPart(new NullPart(){
                                                                    @Override
                                                                    public void doAfter(Game game){
                                                                        dance.stop();
                                                                        eating.start();
                                                                    }
                                                                });
                                                        }
                                                        else if(difficulty==Difficulty.Normal)
                                                        {
                                                            condScene(new Scene(
                                                                    MiscAssets.backgrounds.get("dancebg")));

                                                            condPart(new Dialogue("Feeling bored, you decide to leave him and hang out with your other friends. Hurt by your indirect lack of acknowledgement of his presence Oswaldo sits alone on a table in a corner of the room with his head down."));
                                                        }
                                                        else{
                                                            condScene(new Scene(
                                                                    MiscAssets.backgrounds.get("dancebg"),
                                                                    new engine.Character[] {
                                                                        new Oswaldo(0,0)
                                                                    }
                                                                ));
                                                            condPart(new NullPart(){
                                                                    @Override
                                                                    public void doAfter(Game game){
                                                                        badResponse1.stop();
                                                                    }
                                                                });
                                                            condPart(new Dialogue("Oswaldo is hurt by your rejection, feeling it is necessary to dance at such a party. He is ashamed and embarrassed asking you to dance in front of the crowd, and ends up leaving the dance with his head low."));
                                                            condPart(new NullPart(){
                                                                    @Override
                                                                    public void doAfter(Game game){
                                                                        dance.stop();
                                                                        badResponse1.start();
                                                                    }
                                                                });
                                                        }
                                                    }
                                                }
                                            });

                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("choicebg")));
                                        // This will occur only if the user does not have enough favorability with Oswaldo.

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

                                                        condPart(new Dialogue("He feels allured by your sophistication, thus leaving him with more confirmation that you are the right person for him."));
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

                                                        condPart(new Dialogue("He feels allured by your sophistication, thus leaving him with more confirmation that you are the right person for him."));
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

                                                        condPart(new Dialogue("Oswaldo feels slightly awkward and embarassed about taking you out to the dance."));
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
                                        condPart(new NullPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    badResponse1.stop();
                                                }
                                            });
                                        condPart(new Dialogue("Oswaldo's heart tore a little at the rejection and he slowly turned away once the classroom door shut closed.") );
                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("tttbg")));

                                        condPart(new Dialogue("Although it pained you to reject Oswaldo, you left him to watch your figure gradually disappear back into Professor CoJoglianese's classroom to study the night."));
                                        condPart(new NullPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    dance.stop();
                                                    badResponse1.start();
                                                }
                                            });
                                    }  
                                }
                            });
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("danceSit")));

                        condPart(
                            new EmptyPart()
                        );
                    }else{
                        Clip badResponse1 = engine.MediaPlayer.createClip("./audio/BadResponse1.wav", true);

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("choicebg")));
                        // Based on the favorability of Oswaldo, Oswaldo will come in and be outstanded by your formal wear.
                        condPart(new Choice("what will you wear?", "green dress", "guy suit", "school uniform") {
                                @Override
                                public void doAfter(Game game) {
                                    if(choice1Picked || choice2Picked){
                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("dancebg"),
                                                new engine.Character[] {
                                                    new Oswaldo(0,0)
                                                }
                                            ));
                                        condPart(new Dialogue("Oswaldo didn't answer them, too entralled by you. Maybe he should have asked you to the dance."));

                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("dancebg")));
                                        condPart(new Dialogue("\"Hey, didn't you reject that person?\" One of his friends ask."));

                                        condPart(new Dialogue("Just in that moment, the doors opened and Oswaldo's eyes dropped at the sight of your confidence as you walked in. The outfit was perfectly made for your figure and it was beautifully made."));

                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("dancebg"),
                                                new engine.Character[] {
                                                    new Oswaldo(0,0)
                                                }
                                            ));
                                        condPart(new Dialogue("Oswaldo was minding his own business with his friends at the dance. As his friends were talking, an image of your face appeared in his mind. He quickly shook his head. There was no way you were going to show up to his face."));
                                    }else{

                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("dancebg")));
                                        condPart(new NullPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    badResponse1.stop();
                                                }
                                            });
                                        condPart(new Dialogue("The dance was the moment for all students to express themselves to the highest glamor that they could achieve, and here you were, dressed in your normal school uniform. Compared to the other attendees of the dance, you looked like you had mistakenly entered the ballroom instead of the library."));
                                        condPart(new Dialogue("Just in that moment, the doors opened and Oswaldo's eyes dropped at the sight of you."));
                                        condPart(new NullPart(){
                                                @Override
                                                public void doAfter(Game game){
                                                    dance.stop();
                                                    badResponse1.start();
                                                }
                                            });
                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("dancebg"),
                                                new engine.Character[] {
                                                    new Oswaldo(0,0)
                                                }
                                            ));
                                        condPart(new Dialogue("Oswaldo was minding his own business with his friends at the dance. As his friends were talking, an image of your face appeared in his mind. He quickly shook his head. There was no way you were going to show up to his face."));
                                    }

                                    if(choice1Picked){
                                        if(difficulty == Difficulty.Easy){
                                            affectionMeter += 10;
                                        } else if(difficulty == Difficulty.Normal){
                                            affectionMeter += 5;
                                        }else{
                                            affectionMeter +=1;
                                        }
                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("greendressbg")));

                                        condPart(new Dialogue("You smile brightly at your clothing of choice. Surely, this will woo Oswaldo!"));
                                    }   
                                    else if(choice2Picked){
                                        if(difficulty == Difficulty.Easy){
                                            affectionMeter += 10;
                                        } else if(difficulty == Difficulty.Normal){
                                            affectionMeter += 5;
                                        }else{
                                            affectionMeter += 1;
                                        }
                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("suitbg")));

                                        condPart(new Dialogue("You smile brightly at your clothing of choice. Surely, this will woo Oswaldo!"));
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

                                        condPart(new Dialogue("There was no way Oswaldo would want to be with you in these clothes!"));

                                        condPart(new Dialogue("You cringe at your outfit, but it was the only thing you were able to afford."));
                                    }

                                }
                            });
                    }
                }
            }
        );
        Clip graduation = engine.MediaPlayer.createClip("./audio/graduation.wav", true);

        addScene(new Scene(
                MiscAssets.backgrounds.get("graduation")));

        addPart(new NullPart(){
                @Override
                public void doAfter(Game game){
                    dance.stop();
                    graduation.start();
                }
            });
        // The user has finished their year of Yort and is now at graduation where they have one last situation to raise their favorability with Oswaldo.
        addPart(
            new NullPart(){
                @Override
                public void doAfter(Game game) {
                    if(affectionMeter >= 70 || (difficulty == Difficulty.Impossible && rightChoice)){
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("gradSit")));

                        condScene(new 
                            Scene(
                                MiscAssets.backgrounds.get("choicebg")));

                        condPart(new Choice("What should you say?", "\"I’m always grateful for you looking after me all these years. I couldn’t have asked for a better person to be with!\"", "You go up to Oswaldo and tell him that he's been such a great friend!", "You smile at him and decide to just say goodbye as you just want to get out of school as fast as possible.") {
                                @Override
                                public void doAfter(Game game) {

                                    if(choice1Picked){
                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("graduationbg"),
                                                new engine.Character[] {
                                                    new Oswaldo(0,0)
                                                }
                                            ));

                                        condPart(new Dialogue("No problem, I’m always here to help! Thank you for all your hard work as well.” Oswaldo replies to your formal congratulation. He has a feeling that you have friendzoned him, hurting his pride, but having to hold up his reputation as the Duke of Yort, Oswaldo shows no emotion that would indicate that he was hurt by your words. "));
                                    }
                                    else if(choice3Picked){
                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("graduationbg"),
                                                new engine.Character[] {
                                                    new Oswaldo(0,0)
                                                }
                                            ));

                                        condPart(new Dialogue("Oswaldo glances at you, but doesn’t take the initiative to talk to you. He feels a barrier between him and you, not having enough interest to cross the distance towards you."));
                                    }
                                    else{
                                        dating = true;
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
                    }else{

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("graduationbg")
                            ));

                        condPart(new Dialogue("You stood at the dust of what remained of Oswaldo. All. Alone."));

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("graduationbg"),
                                new engine.Character[] {
                                    new Oswaldo(0,0),
                                    new BoJiden(50,50)
                                }
                            ));

                        condPart(new Dialogue("\"Thank you father.\" He smiles. As you were approaching him, his smile fell of his face. He looked at his father. \"Let's go now, shall we?\" He quickly urged his father out of school and snapped a sharp frown at your direction."));

                        condPart(new Dialogue("\"I'm proud of you, son.\" Duke Bo Jiden tells his son."));

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("graduationbg"),
                                new engine.Character[] {
                                    new Oswaldo(0,0)
                                }
                            ));

                        condPart(new Dialogue("After all the hardships, you had at last graduated from Yort High School. You scanned the crowd of other graduated students with their families to look for Oswaldo. After a few seconds and a lot of squinting, you finally catch a familiar brown hair next to an older man."));

                    }
                }
            }
        );

        addScene(new 

            Scene(
                MiscAssets.backgrounds.get("endScene")));
        addPart(new NullPart(){
                @Override
                public void doAfter(Game game){
                    graduation.stop();
                    mainTheme.start();
                }
            });

        addPart(
            new 

            NullPart() {
                @Override
                public void doAfter(Game game) {
                    Clip proposal = engine.MediaPlayer.createClip("./audio/proposal.wav", true);
                    Clip badResponse3 = engine.MediaPlayer.createClip("./audio/BadResponse3.wav", true);
                    Clip goodResponse2 = engine.MediaPlayer.createClip("./audio/GooderResponse2.wav", true);

                    if(dating == true ){
                        // Based on your affection with Oswaldo, the game will see if you gained the favorable outcome or not.
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("choicebg")));

                        condPart(new Choice("Do you say yes?", "Yes!", "No!") {
                                @Override
                                public void doAfter(Game game) {

                                    if(choice1Picked){
                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("endbg")));

                                        condPart(new EmptyPart());

                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("churchbg"),
                                                new engine.Character[] {
                                                    new Oswaldo(0,0)
                                                }
                                            ));

                                        condPart(new Dialogue("Church bells ring as the priest asks, “Do you take the Duke of Yort, Oswaldo, to be your lawfully wedded husband?” You happily say 'yes' and become married, living happily ever after with three cats and two dogs, as well as five ducks. "));

                                    }
                                    else{
                                        if(Difficulty.Normal == difficulty || difficulty == Difficulty.Easy){
                                            condScene(new Scene(
                                                    MiscAssets.backgrounds.get("choicebg")));

                                            condPart(new Choice("Are you sure with your answer?", "Yes!", "No!") {
                                                    @Override
                                                    public void doAfter(Game game) {
                                                        if(choice1Picked){
                                                            condScene(new Scene(
                                                                    MiscAssets.backgrounds.get("endbg")));

                                                            condPart(new EmptyPart());

                                                            condScene(new Scene(
                                                                    MiscAssets.backgrounds.get("churchbg"),
                                                                    new engine.Character[] {
                                                                        new Oswaldo(0,0)
                                                                    }
                                                                ));

                                                            condPart(new Dialogue("Church bells ring as the priest asks, “Do you take the Duke of Yort, Oswaldo, to be your lawfully wedded husband?” You happily say 'yes' and become married, living happily ever after with three cats and two dogs, as well as five ducks. ")); 
                                                        }
                                                        else{
                                                            condScene(new Scene(
                                                                    MiscAssets.backgrounds.get("badOver")));

                                                            condPart(new NullPart(){
                                                                    @Override
                                                                    public void doAfter(Game game){
                                                                        goodResponse2.stop();
                                                                        badResponse3.start();
                                                                        badResponse3.stop();
                                                                    }
                                                                });

                                                            condScene(new Scene(
                                                                    MiscAssets.backgrounds.get("freedombg")));

                                                            condPart(new Dialogue("You chose to be free and live solo"));
                                                            condPart(new NullPart(){
                                                                    @Override
                                                                    public void doAfter(Game game){
                                                                        proposal.stop();
                                                                        goodResponse2.start();
                                                                    }
                                                                });
                                                        }
                                                    }
                                                });   

                                            condScene(new Scene(
                                                    MiscAssets.backgrounds.get("bedroom"),
                                                    new engine.Character[] {
                                                        new Oswaldo(0,0)
                                                    }
                                                ));

                                            condPart(new Dialogue("He puts the ring back in his pocket and gets up from the floor dejectedly. Oswaldo, not looking at you at all, turns away heartbroken. Before he leaves the door, you have final decision to make..."));
                                        }else{
                                            condPart(new NullPart(){
                                                    @Override
                                                    public void doAfter(Game game){
                                                        badResponse3.stop();
                                                    }
                                                });
                                            condScene(new Scene(
                                                    MiscAssets.backgrounds.get("ripbg")));

                                            condPart(
                                                new FullScreenMessage(
                                                    MiscAssets.generateBackgroundInfo(MainCharacter.name)
                                                )
                                            );
                                            condPart(new NullPart(){
                                                    @Override
                                                    public void doAfter(Game game){
                                                        proposal.stop();
                                                        badResponse3.start();
                                                    }
                                                });
                                        }

                                    }
                                }
                            });
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("marriageSit")));

                        condPart(new NullPart(){
                                @Override
                                public void doAfter(Game game){
                                    graduation.stop();
                                    proposal.start();
                                }
                            });
                    }else if(rightChoice == false){
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("BADover")));

                        condPart(new EmptyPart(){
                                @Override
                                public void doAfter(Game game){
                                    goodResponse2.stop();
                                    badResponse3.start();
                                    badResponse3.stop();
                                }
                            });
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("ripbg")));

                        condPart(
                            new FullScreenMessage(
                                MiscAssets.generateName(MainCharacter.name)
                            )
                        );
                        condPart(new NullPart(){
                                @Override
                                public void doAfter(Game game){
                                    proposal.stop();
                                    goodResponse2.start();
                                }
                            });
                    }else{
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("endbg")));

                        condPart(new EmptyPart());

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("freedombg")));

                        condPart(new Dialogue("You chose to live solo."));

                        condPart(new Dialogue("After you split, Oswaldo married a young noble lady whom he cherishes deeply, and inherited his title as Duke. \n As for you. . ."));

                        condPart(new Dialogue("Oswaldo still thinks of you every now and then, but it was best that you never got together."));

                        condPart(new Dialogue("After you graduated, you returned to your home and began managing the estate on the countryside. Once in a while, Oswaldo pops up in your mind as you do paperwork or do maintenance checks."));

                    }
                }
            }
        );
        // Credits are shown 
        addScene(new Scene(
                MiscAssets.backgrounds.get("credits")));

        addPart(new NullPart(){
                @Override
                public void doAfter(Game game){
                    mainTheme.stop();
                }
            });
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

        addPart(new Dialogue("Skibidi dom dom what?") {
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
