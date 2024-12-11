
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import utils.BgPanel;
import utils.TransparentPanel;
import utils.ImgButton;
import engine.Game;
import javax.imageio.ImageIO;
import java.awt.Image;


public abstract class TicTacToe extends engine.MiniGame {
    /**
     * Constructor for objects of class MiniGame
     */
    private engine.MinigameDifficulty difficulty;
    protected boolean playerWon;
    protected boolean draw = false;
    private static Image xImg = null;
    private static Image oImg = null;
    private static Image emptyImg = null;
    static {
        try {
            emptyImg = ImageIO.read(
                EntryPoint.class.getResource("assets/ticEmpty.png")
            );
            xImg = ImageIO.read(
                EntryPoint.class.getResource("assets/ticX.png")
            );
            oImg = ImageIO.read(
                EntryPoint.class.getResource("assets/ticO.png")
            );
        } catch (Exception e) {
            System.err.println("failed to read tic tac toe assets");
        }
    }
    
    //private boolean isPlayer;
    public TicTacToe(engine.MinigameDifficulty difficulty) {
        super(difficulty);
    }
    enum Placed {
        Empty, X, O
    }
    class TicBtn extends ImgButton {
        public boolean clicked;
        public Placed placed;
        private void set(Placed placed) {
            this.placed = placed;
            if (placed == Placed.X)
                setImg(xImg);
            else setImg(oImg);
        }

        public TicBtn(TicTacToe currentGame, Game game) {
            super(emptyImg, 0.05);
            this.placed = Placed.Empty;
            addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (placed == Placed.Empty) {
                            set(Placed.X);
                            currentGame.update(game);
                        }
                    }
                });
            //this.setBorder(new EmptyBorder(10, 10, 10, 10));

        }
    }
    public TicBtn getEnemyMove() {
        Random rand = new Random();
        TicBtn btn = null;
        do {
            btn = grid[rand.nextInt(3)][rand.nextInt(3)];
        } while (btn.placed != Placed.Empty);
        return btn;
    }
    public void update(Game game) {
        System.out.println(hasVictor());
        if (hasVictor()) {
            playerWon = true;
            call(game);
        } else {
            TicBtn move = getEnemyMove();
            if (move == null) {
                draw = true;
                playerWon = false;
                call(game);
            } else  {
                getEnemyMove().set(Placed.O);
                if (hasVictor()) {
                    playerWon = false;
                    call(game);
                }
            }
        }
    }
    private TicBtn[][] grid = new TicBtn[3][3];
    public void changeUI(engine.Game game) {
        BgPanel pane = new BgPanel(new BorderLayout(), MiscAssets.backgrounds.get("desk"));
        pane.setBorder(new EmptyBorder(110, 110, 110, 110));
        //JPanel panel = new TransparentPanel(new BorderLayout());
        JPanel gridPanel = new TransparentPanel(new GridLayout(3, 3));
        pane.add(gridPanel, BorderLayout.CENTER);
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++) {
                grid[row][col] = new TicBtn(this, game);
                gridPanel.add(grid[row][col]);
            }

        game.setCenterPanel(pane);
    }
    private boolean hasVictor() {
        boolean winner = false;
        Placed[] winningTypes = new Placed[] {Placed.X, Placed.O};
        for (Placed place : winningTypes) {
            for (int i = 0; i < 3; i++) {
                winner |= grid[0][i].placed == place && grid[1][i].placed == place && grid[2][i].placed == place;
                winner |= grid[i][0].placed == place && grid[i][1].placed == place && grid[i][2].placed == place;
            }
            winner |= grid[0][0].placed == place && grid[1][1].placed == place && grid[2][2].placed == place;
            winner |= grid[2][0].placed == place && grid[1][1].placed == place && grid[0][2].placed == place;
        }
        return winner;
    }

}