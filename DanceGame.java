import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;
import utils.BgPanel;
import java.util.Arrays;
import engine.MinigameDifficulty;

public abstract class DanceGame extends engine.MiniGame{
    /**
     * Constructor for objects of class MiniGame
     */

    final static String[] keys = new String[] {
            "up",
            "down",
            "left",
            "right"
        };
    boolean wasPressed = false;
    boolean firstRun = true;
    int currentKey = 0;
    int points = 0;
    int totalPoints = 0;
    private boolean finished = false;
    Timer timer = null;

    private String[] moves;
    private String[] generateKeys(int numMoves){
        moves = new String[numMoves];
        Random rand = new Random();
        for(int i = 0; i < numMoves; i++)
            moves[i] = keys[rand.nextInt(keys.length)];

        return moves;
    }

    private void setKey() {
        if (panel != null)
            panel.setBgImg(MiscAssets.backgrounds.get(moves[currentKey]));
        System.out.println(moves[currentKey]);
    }

    public DanceGame(MinigameDifficulty difficulty) {
        super(difficulty);
    }

    private BgPanel panel = null;
    private void addKeyBind(engine.Game game, int keyCode, String keyName) {
        /*JComponent[] components = new JComponent[] {
            game,
            panel,
            game.getCanvas()
        };
        for (JComponent comp : components) {*/
        game.getCanvas().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keyCode, 0), keyName);
        game.getCanvas().getActionMap().put(keyName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!finished) {
                    System.out.println(keyName);
                    panel.setBgImg(MiscAssets.backgrounds.get("balconybg"));
                    if (!wasPressed) {
                        if(moves[currentKey-1] == keyName)
                            points += 100;
                    }
                }
            }
        });
        //}
    }
    public void changeUI(engine.Game game) {
        panel = new BgPanel(new BorderLayout(), MiscAssets.backgrounds.get("balconybg"));
        int seconds;

        if(difficulty == MinigameDifficulty.Basic){
            seconds = 2000;
            generateKeys(10);
            totalPoints = 10*100;
        } else if (difficulty == MinigameDifficulty.Medium){
            seconds = 1500;
            generateKeys(15);
            totalPoints = 15*100;
        } else {
            seconds = 1000;
            generateKeys(25);
            totalPoints =25*100;
        }
        System.out.println(Arrays.asList(moves));

        timer = new Timer(seconds, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentKey == moves.length-1){
                        System.out.println("game finished. You have: " + points + " points");
                        finished = true;
                        timer.stop();
                        call(game);
                    } else {
                        setKey();
                        if (!firstRun) {
                            currentKey++;
                            wasPressed = false;
                        }
                        firstRun = false;
                    }
                }
            });
        timer.start();
        
        addKeyBind(game, KeyEvent.VK_RIGHT, "right");
        addKeyBind(game, KeyEvent.VK_LEFT, "left");
        addKeyBind(game, KeyEvent.VK_UP, "up");
        addKeyBind(game, KeyEvent.VK_DOWN, "down");
        
        game.setCenterPanel(panel);
    }

}