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
    private void addKeyBind(int keyCode, String keyName) {
        panel.getInputMap().put(KeyStroke.getKeyStroke(keyCode, 0), keyName);
        panel.getActionMap().put(keyName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBgImg(MiscAssets.backgrounds.get("balconybg"));
                if (!wasPressed) {
                    if(moves[currentKey-1] == keyName)
                        points += 100;
                }
            }
        });
    }
    public void changeUI(engine.Game game) {
        panel = new BgPanel(new BorderLayout(), MiscAssets.backgrounds.get("balconybg"));
        int seconds;

        if(difficulty == MinigameDifficulty.Basic){
            seconds = 2000;
            generateKeys(10);
        } else if (difficulty == MinigameDifficulty.Medium){
            seconds = 1500;
            generateKeys(15);
        } else {
            seconds = 1000;
            generateKeys(25);
        }
        System.out.println(Arrays.asList(moves));

        timer = new Timer(seconds, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentKey == moves.length-1){
                        System.out.println("game finished. You have: " + points + " points");
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
        
        addKeyBind(KeyEvent.VK_RIGHT, "right");
        addKeyBind(KeyEvent.VK_LEFT, "left");
        addKeyBind(KeyEvent.VK_UP, "up");
        addKeyBind(KeyEvent.VK_DOWN, "down");
        
        game.setCenterPanel(panel);
    }

}