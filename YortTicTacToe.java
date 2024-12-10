import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.*;
import javax.swing.*;
import utils.TransparentPanel;

public class YortTicTacToe extends TicTacToe{
    /**
     * Constructor for objects of class MiniGame
     */
    private engine.MinigameDifficulty difficulty;
    protected Class winner;
    private boolean isPlayer;
    
    class TicBtn extends JButton {
        public boolean clicked;
        public Placed placed;
        private void set(Placed placed) {
            this.placed = placed;
            if (placed == Placed.X)
                super.setText("x");
            else super.setText("o");
        }
        public TicBtn(TicTacToe currentGame) {
            super("-");
            this.placed = Placed.Empty;
            super.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (isPlayer)
                        set(Placed.X);
                    else
                        set(Placed.O);
                    currentGame.update();
                }
            });
        }
    }
    public void update() {
    }
    public void changeUI(engine.Game game) {
        BackgroundPanel panel = new BackgroundPanel(new BorderLayout());
        BackgroundPanel gridPanel = new BackgroundPanel(new GridLayout(3, 3));
        panel.add(gridPanel, BorderLayout.CENTER);
        TicBtn[][] grid = new TicBtn[3][3];
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++) {
                grid[row][col] = new TicBtn(this);
            }

        game.setPanel(panel);
    }
    public void finish(Class winner) {
        this.winner = winner;
    }
    public finish
}