import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.Random;

public class TestingGame extends JFrame implements KeyListener {
    final static String[] keys = new String[] {
            "up",
            "down",
            "left",
            "right"
        };

    private static String[] generateKeys(int numMoves){
        String[] moves = new String[numMoves];

        Random rand = new Random();
        int randNum;

        for(int i = 0; i < numMoves; i++){
            randNum = rand.nextInt(3);
            moves[i] = keys[randNum];
        } 

        return moves;
    }
    boolean wasPressed = false;
    int currentKey = 0;
    int points = 0;
    JLabel label = new JLabel("");
    Timer timer = null;
    private void setKey() {
        if (currentKey != keys.length)
            label.setText(keys[currentKey]);
    }

    public TestingGame() {
        super("testing game window");
        setMinimumSize(new Dimension(854, 480));
        //
        int seconds;
        int numKeys;
        String difficulty = "Easy";
        if(difficulty == "Easy"){
            seconds = 4000;
            generateKeys(10);
            numKeys = 10;
        }
        else if(difficulty == "Normal"){
            seconds = 6000;
            generateKeys(15);
            numKeys = 15;
        }
        else{
            seconds = 9000;
            generateKeys(25);
            numKeys = 25;
        }

        timer = new Timer(seconds, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setKey();
                    if (currentKey == generateKeys(numKeys).length){
                        System.out.println("game finished. You have: " + points + " points");
                        timer.stop();
                    } else {
                        currentKey++;
                        wasPressed = false;
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
        System.out.println(currentKey);
        if(!wasPressed)
            switch(keyCode) {

                case KeyEvent.VK_UP:
                    // handle up
                    if(keys[currentKey-1] == "up"){
                        points += 100;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    // handle down
                    if(keys[currentKey-1] == "down"){
                        points += 100;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    // handle left
                    if(keys[currentKey-1] == "left"){
                        points += 100;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    // handle right
                    if(keys[currentKey-1] == "right"){
                        points += 100;
                    }
                    break;
            }
    }

    public void keyReleased(KeyEvent e) {

    }

}
