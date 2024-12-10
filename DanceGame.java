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
    JLabel label = new JLabel("");
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
        label.setText(moves[currentKey]);
    }

    public DanceGame(MinigameDifficulty difficulty) {
        super(difficulty);
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        engine.MediaPlayer.createClip("./audio/buttonClick.wav", false).start();
        if(!wasPressed) {
            switch(keyCode) {

                case KeyEvent.VK_UP:
                    // handle up
                    BgPanel bg = new BgPanel(new BorderLayout(), MiscAssets.backgrounds.get("up"));

                    if(moves[currentKey-1] == "up"){
                        points += 100;

                    }
                    break;
                case KeyEvent.VK_DOWN:
                    // handle down
                    bg = new BgPanel(new BorderLayout(), MiscAssets.backgrounds.get("down"));

                    if(moves[currentKey-1] == "down"){
                        points += 100;

                    }
                    break;
                case KeyEvent.VK_LEFT:
                    // handle left
                    bg = new BgPanel(new BorderLayout(), MiscAssets.backgrounds.get("left"));

                    if(moves[currentKey-1] == "left"){
                        points += 100;

                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    // handle right
                    bg = new BgPanel(new BorderLayout(), MiscAssets.backgrounds.get("right"));

                    if(moves[currentKey-1] == "right"){
                        points += 100;

                    }
                    break;
            }
            label.setText("!");
        }
    }

    public void changeUI(engine.Game game) {
        BgPanel panel = new BgPanel(new BorderLayout(), MiscAssets.backgrounds.get("balconybg"));
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
                        label.setText("game finished. You have: " + points + " points");
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

        panel.add(label);

        game.setCenterPanel(panel);
    }
    public void keyReleased(KeyEvent e) {

    }
    
    public int score(int points){
        return points;
    }
}