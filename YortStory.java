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

        Clip clip = engine.MediaPlayer.createClip("./audio/breezeway.wav", true);

        addScene(new Scene(
                MiscAssets.backgrounds.get("base")));

        addPart(
            new FullScreenMessage(
                MiscAssets.generateBackgroundInfo(MainCharacter.name)
            ){
                @Override
                public void onLoad(Game game){
                    clip.start();
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
                MiscAssets.backgrounds.get("introDiff"))
        );

        addPart(
            new EmptyPart());
            
        //Clip audioClip= engine.MediaPlayer.createClip("./audio/buttonClick.wav", true);
        
        addScene(new Scene(
                MiscAssets.backgrounds.get("brrrwayMeeting")));

        addPart(
            new EmptyPart(){
                @Override
                public void doAfter(Game game){
                    clip.stop();
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

        addPart(new Choice("What do you do?", "Be nice and introduce yourself \"Oh, I’m so sorry! I didn’t see you there.\"", "be rude and lash out: \"Hey watch where you're going! Some of us are trying to go to class.\"", "be mysterious and whip those luscious locks!!" ) {
                @Override
                public void doAfter(Game game) {
                    if (choice1Picked){ // this comes from a property in Choice
                        //Clip audioClip= engine.MediaPlayer.createClip("./audio/buttonClick.wav", true);
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("choicebg"),
                                new engine.Character[] {
                                    new Oswaldo(0,0)
                                }
                            ));

                        condPart(new Choice("How do you start the conversation?", "\"So, what do you like to do for fun? I’m really into photography. I love capturing moments.\"", "\"I’ve been wanting to check out the new art exhibit. Want to come with me this weekend?\"", "\"Do you believe in love at first sight, or should I walk by again?\"") {
                                @Override
                                public void doAfter(Game game) {
                                    condScene(new Scene(
                                            MiscAssets.backgrounds.get("cafebg"),
                                            new engine.Character[] {
                                                new Oswaldo(0,0)
                                            }
                                        ));
                                    if(choice1Picked){
                                        condPart(new Dialogue("He lights up and shares that he enjoys playing guitar. As you talk, he mentions he’s performing at the school talent show next week. You decide to support him and plan to attend the show together. Oswaldo feels appreciated and has a good impression of you.", MainCharacter.class));

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
                                        condPart(new Dialogue("Oswaldo hasn’t had a good laugh in a while and has a good impression of you.", Oswaldo.class));

                                        condPart(new Dialogue("He notices and says,\"Seems like we’ve caught some attention. Want to give them something to talk about?\" You both laugh and decide to take a fun selfie together.", Oswaldo.class));  

                                        condPart(new Dialogue("As you chat, you notice a few classmates whispering and pointing."));

                                        condPart(new Dialogue("\"That sounds amazing! I’ve heard great things about it. Let’s make it a plan!\"", Oswaldo.class));

                                        if(difficulty == Difficulty.Easy){
                                            affectionMeter += 5;
                                        } else if(difficulty == Difficulty.Normal){
                                            affectionMeter += 3;
                                        }
                                        else{
                                            affectionMeter +=1;
                                        }
                                    }else{
                                        condPart(new Dialogue("You both head back to school, where you sit together in the cafeteria. The playful banter continues, and you challenge each other to a game of “Two Truths and a Lie,” revealing surprising truths about yourselves. You leave a humorous and fun impression on Oswaldo."));

                                        condPart(new Dialogue("He laughs, clearly amused. \"Well, you’ve definitely caught my attention. Let’s see if you can keep it.\"", Oswaldo.class));

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
                        condPart(new Dialogue("After school, you both head to the nearby cafe. As you sit down, you notice a group of your classmates walk in and glance over.", MainCharacter.class));

                        condPart(new Dialogue("The two stood in silence, but you hope he didn't hear your thumping heart. After a few seconds, he suggests grabbing coffee.", Oswaldo.class));

                        condPart(new Dialogue("\"Hey, no worries at all! It was an accident. I’m sure you didn’t mean to. My name is Oswaldo,\" he smiles warmly.", Oswaldo.class));
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
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("choicebg")

                            ));
                        condPart(new Choice("How do you start the conversation?", "\"Wait, I didn’t mean it like that. Can we start over?\"", "\"Whatever, it’s not like I care. I have places to be.\"", "\"Whatever, it’s not like I care. I have places to be.\"") {
                                @Override
                                public void doAfter(Game game){
                                    condScene(new Scene(
                                            MiscAssets.backgrounds.get("hallwaybg"),
                                            new engine.Character[] {
                                                new Oswaldo(0,0)
                                            }
                                        ));
                                    if(choice1Picked){
                                        condPart( new Dialogue("You both head to class together, and during a group project, you find yourselves paired up. As you work, you realize he’s actually pretty cool, and you start to enjoy his company. However, you notice that he is still cautious of you."));

                                        condPart(new Dialogue("He turns back, a cautious smile on his face. \"Sure, I’m Oswaldo. Let’s pretend I didn’t just get insulted.\""));

                                    }
                                    else if(choice2Picked){
                                        condPart(new Dialogue("He raises an eyebrow, clearly unimpressed. \"Alright then. Good luck with your busy schedule.\""));
                                        condPart(new Dialogue("He walks away, and as you sit in class, you can’t help but feel a bit guilty. Later, during lunch, you overhear him talking to friends about how he prefers people who are genuine."));
                                        condPart(new Dialogue("You left a bad impression on him."));

                                        if(difficulty == Difficulty.Normal){
                                            affectionMeter -= 5;
                                        }
                                        else{
                                            affectionMeter -= 10;
                                        }
                                    }else{
                                        condPart(new Dialogue("He smirks. \"Well, if that was a test, I’d say I passed. What’s your real story?\""));
                                        condPart(new Dialogue("Intrigued by your boldness, Oswaldo stays to chat. You both end up sitting together at lunch, where he challenges you to a debate about school rules, and surprisingly, you find you have similar views. However, he is still suspicious of your behavior."));
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
                        if(difficulty == Difficulty.Normal){
                            affectionMeter -= 5;
                        }else if(difficulty == Difficulty.Impossible){
                            affectionMeter -= 20;
                        }

                        condPart(new Dialogue("Oswaldo, the guy you bumped into, looks at you confused, but as he is polite, he doesn’t want to cause a big scene. “Hey, no need to be rude. It was an accident.”", Oswaldo.class));
                    } else{
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("choicebg"),
                                new engine.Character[] {
                                    new Oswaldo(0,0)
                                }
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
                                    if(choice1Picked){
                                        condPart(new Dialogue("As you toss your hair back dramatically, you feel the eyes of the hallway on you. The movement is fluid, confident, and you can’t help but feel a rush of empowerment. You stride away, but you can’t shake the feeling that he’s still watching you."));
                                        condPart(new Dialogue("\"Wow,\" he says softly, almost to himself, as you walk past. You glance back just in time to see him shake his head. You’ve piqued his intrest, but Oswaldo is a bit hurt with you not apologizing.", Oswaldo.class));
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
                                    }
                                }
                            });
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("hallwaybg"),
                                new engine.Character[] {
                                    new Oswaldo(0,0)
                                }
                            ));
                        condPart(new Dialogue("The guy you bumped into was Oswaldo. He looks at you as if waiting for you to say something, but you don’t.", Oswaldo.class));

                        if(difficulty == Difficulty.Normal){
                            condPart(new Dialogue("He now has an interest of neither dislike nor like of you."));
                        }else if(difficulty == Difficulty.Impossible){
                            affectionMeter -= 10;
                        }
                    }
                }
            });

        addScene(new 
            Scene(
                MiscAssets.backgrounds.get("ticTacToe")));

        addPart(new Dialogue(""));

        addScene(new 
            Scene(
                MiscAssets.backgrounds.get("tttSit")));

        addPart(new 

            Choice("Will you play Tic Tac Toe", "yes", "no") {
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

                                condScene(new Scene(
                                        MiscAssets.backgrounds.get("coJogClass"),
                                        new engine.Character[] {
                                            new CoJoglianese(0,0)
                                        }
                                    ));

                                condPart(new Dialogue("What are you two doing here so late? Go back home and sleep!", CoJoglianese.class));

                                condScene(new Scene(
                                        MiscAssets.backgrounds.get("coJogClass")
                                    ));

                                condPart(new Dialogue("Suddenly the door burst open."));
                                condPart(new Dialogue("He glances at you working very studiously, and a smile arises on his lips. \n He quickly catches himself and turns back to his own work, scribbling furiously.", Oswaldo.class));
                            } else {
                                affectionMeter += 10;

                                condPart(new Dialogue("\"I'm glad to help.\"", Oswaldo.class));

                                condPart(new Dialogue("Once you finished all your work, you thank Oswaldo for his help.", MainCharacter.class));

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

        addScene(new Scene(
                MiscAssets.backgrounds.get("awkward")
            ));

        addPart(new Dialogue(""));

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
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("schoolbg")
                            ));
                        condPart(new Dialogue("\"I don't mind,\" you say very quietly.", Oswaldo.class));

                        condPart(new Dialogue("Oswaldo looks hopefully at you. Once your friend is out of sight he stands closer to you and apologizes for his previous behavior.", Oswaldo.class));
                    } else if(choice2Picked){
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("schoolbg")
                            ));

                        if(difficulty == Difficulty.Normal){    
                            affectionMeter -= 5;

                            condPart(new Dialogue("You thought that Oswaldo would have pretended that nothing happened, but it's been a whole month since you've seen him.", MainCharacter.class));

                            condPart(new Dialogue("Oswaldo looks after you in despair. Any hope he had of fixing the relationship has just been diminished into dust. Head down low, he walks away from the shame of your rejection."));
                        }else if(difficulty == Difficulty.Impossible){
                            condPart(new Dialogue("Oswaldo is disappointed by your behavior. He makes a mental note to never speak to you again. He leaves, and you stare after him heartbroken."));
                            affectionMeter -=20;
                        }else{
                            condPart(new Dialogue("After you left, Oswalso chased after you. \n \"Are you okay. I'm sorry about those guys making jokes like that.\"", Oswaldo.class));
                        }
                    }else{
                        condScene(new Scene(
                                MiscAssets.backgrounds.get("schoolbg")
                            ));
                        if(difficulty == Difficulty.Easy || (difficulty == Difficulty.Impossible && rightChoice == true)){
                            condPart(new Dialogue("\"Nothing.\" he says covering his face with his other hand. His friends whisper between each other snickering at Oswaldo's flushed faced."));
                            condPart(new Dialogue("\"What's wrong?\" you ask.", MainCharacter.class));
                            condPart(new Dialogue("Oswaldo turned a bright shade of pink at the touch of your hand.", Oswaldo.class));
                            if(difficulty == Difficulty.Easy){
                                affectionMeter += 15;
                            }else if(difficulty == Difficulty.Impossible){
                                affectionMeter +=5;
                            }
                        }else if(difficulty == Difficulty.Normal && affectionMeter >= 70){
                            condPart(new Dialogue("Oswaldo looks at your interlocked hands, and a pink hue rises to his face.", Oswaldo.class));
                        }else if(difficulty == Difficulty.Normal){
                            condPart(new Dialogue("Oswaldo looks at your interlocked hands with a weird expression and slowly pulls away. He doesn't think that you're close enough to do that", Oswaldo.class));
                        }else{
                            condPart(new Dialogue("Oswaldo snatches his hands away and looks at you in disgust. \n \"I didn't give you permission to touch me\"", Oswaldo.class));
                        }
                    }
                }
            });
        
            //change to nullPart or something else
            addPart(
            new EmptyPart(){
                @Override
                public void doAfter(Game game) {
                    if((difficulty == Difficulty.Easy 
                        || difficulty == difficulty.Normal) && affectionMeter >= 70 
                    || (difficulty == Difficulty.Impossible && rightChoice)){

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("dance")));

                        condPart(new Dialogue(""));

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("danceSit")));

                        condPart(
                            new EmptyPart()
                        );

                        condScene(new Scene(
                                MiscAssets.backgrounds.get("choicebg")));

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
                                        condScene(new Scene(
                                                MiscAssets.backgrounds.get("dancePartner")));

                                        condPart(new Choice("dance with oswaldo?", "yes", "no") {
                                                @Override
                                                public void doAfter(Game game) {

                                                    if(choice1Picked){
                                                        //call game here

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
                    }else{
                        addScene(new Scene(
                                MiscAssets.backgrounds.get("dance")));

                        addPart(new Dialogue(""));

                        addScene(new Scene(
                                MiscAssets.backgrounds.get("choicebg")));

                        addPart(new Choice("what will you wear?", "green dress", "guy suit", "school uniform") {
                                @Override
                                public void doAfter(Game game) {
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

                                        condPart(new Dialogue("You smile brightly at your clothing of choice. Surely, this will woo Oswaldo!", MainCharacter.class));
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

                                        condPart(new Dialogue("You smile brightly at your clothing of choice. Surely, this will woo Oswaldo!", MainCharacter.class));
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

                                        condPart(new Dialogue("You cringe at your outfit, but it was the only thing you were able to afford.", MainCharacter.class));
                                    }  
                                }
                            });
                    }
                }
            }
        );
        

        addScene(new Scene(
                MiscAssets.backgrounds.get("graduation")));

        addPart(new Dialogue(""));

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

        addPart(new Dialogue(""));

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
