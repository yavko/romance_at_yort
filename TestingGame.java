import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.Random;
import java.util.Arrays;

public class TestingGame extends JFrame implements KeyListener {
    final static String[] keys = new String[] {
            "up",
            "down",
            "left",
            "right"
        };
    private String[] moves;
    private String[] generateKeys(int numMoves){
        moves = new String[numMoves];
        Random rand = new Random();
        for(int i = 0; i < numMoves; i++)
            moves[i] = keys[rand.nextInt(keys.length)];

        return moves;
    }
    boolean wasPressed = false;
    boolean firstRun = true;
    int currentKey = 0;
    int points = 0;
    JLabel label = new JLabel("");
    Timer timer = null;
    private void setKey() {
        label.setText(moves[currentKey]);
    }

    public TestingGame() {
        super("testing game window");
        setMinimumSize(new Dimension(854, 480));
        //
        int seconds;
        Difficulty difficulty = Difficulty.Impossible;
        if(difficulty == Difficulty.Easy){
            seconds = 2000;
            generateKeys(10);
        } else if (difficulty == Difficulty.Normal){
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

        add(label);
        //
        addKeyListener(this);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TestingGame::new);
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(!wasPressed) {
            switch(keyCode) {

                case KeyEvent.VK_UP:
                    // handle up
                    if(moves[currentKey-1] == "up"){
                        points += 100;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    // handle down
                    if(moves[currentKey-1] == "down"){
                        points += 100;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    // handle left
                    if(moves[currentKey-1] == "left"){
                        points += 100;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    // handle right
                    if(moves[currentKey-1] == "right"){
                        points += 100;
                    }
                    break;
            }
            label.setText("-");
        }
    }

    public void keyReleased(KeyEvent e) {

    }

}
