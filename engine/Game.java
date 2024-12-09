package engine;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.io.File;
import java.awt.event.*;

public class Game<T> extends JPanel {
    /**
     * Constructor for objects of class Game
     */
    private GameCanvas canvas;
    private final Story story;
    private T dataStore;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private JFrame parentFrame;
    //private Font textFont;
    private UISettings uiSettings;
    public Game(Image gameBg, Story story, T dataStore, UISettings uiSettings, JFrame frame) {
        super(new BorderLayout(10, 10));
        setBackground(new Color(0,0,0));
        //super(gameBg);
        //super.setLayout(new OverlayLayout(this));
        this.story = story;
        this.dataStore = dataStore;
        this.uiSettings = uiSettings;
        this.parentFrame = frame;
        /*try {
        //this.textFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        } catch (Exception e) {
        e.printStackTrace();
        }*/
        this.canvas = new GameCanvas(new BorderLayout(10, 10));
        this.canvas.setMaximumSize(new Dimension(1920, 1080));
        nextScene();
        nextPart();
        add(canvas, BorderLayout.CENTER);
    }

    public UISettings getUISettings() {
        return uiSettings;
    }

    public JFrame getParentFrame() {
        return parentFrame;
    }
    
    public void removeCenterPanel() {
        if (centerPanel != null) {
            canvas.remove(centerPanel);
            this.centerPanel = null;
            canvas.revalidate();
            canvas.repaint();
        }
    }

    public void removeBottomPanel() {
        if (bottomPanel != null) {
            canvas.remove(bottomPanel);
            this.bottomPanel = null;
            canvas.revalidate();
            canvas.repaint();
        }
    }

    public void setPanels(JPanel newCenter, JPanel newBottom) {
        if (centerPanel != null) {
            canvas.remove(centerPanel);
            this.centerPanel = newCenter;
            canvas.add(newCenter, BorderLayout.CENTER);
            //canvas.revalidate();
            //canvas.repaint(); // not sure if needed
        } else {
            this.centerPanel = newCenter;
            canvas.add(newCenter, BorderLayout.CENTER);
        }
        if (bottomPanel != null) { 
            canvas.remove(bottomPanel);
            this.bottomPanel = newBottom;
            canvas.add(newBottom, BorderLayout.PAGE_END);
            //canvas.revalidate();
            //canvas.repaint(); // not sure if needed
        } else {
            this.bottomPanel = newBottom;
            canvas.add(newBottom, BorderLayout.PAGE_END);
        }
        canvas.revalidate();
        canvas.repaint(); // not sure if needed
    }
    
    public void setCenterPanel(JPanel newPanel) {
        removeBottomPanel();
        if (centerPanel != null) {
            canvas.remove(centerPanel);
            this.centerPanel = newPanel;
            canvas.add(newPanel, BorderLayout.CENTER);
            canvas.revalidate();
            canvas.repaint(); // not sure if needed
        } else {
            this.centerPanel = newPanel;
            canvas.add(newPanel, BorderLayout.CENTER);
        }
    }

    public void setBottomPanel(JPanel newPanel) {
        removeCenterPanel();
        if (bottomPanel != null) { 
            canvas.remove(bottomPanel);
            this.bottomPanel = newPanel;
            canvas.add(newPanel, BorderLayout.PAGE_END);
            canvas.revalidate();
            canvas.repaint(); // not sure if needed
        } else {
            this.bottomPanel = newPanel;
            canvas.add(newPanel, BorderLayout.PAGE_END);
        }
    }
    private Scene currentScene;
    private ScenePart currentScenePart; // needs to be rendered
    //private boolean finished = false;
    private boolean firstScene = true;
    private boolean fadding = false;
    
    public void nextScene() {
        Scene nextScene = story.getScenes().poll();
        if (nextScene != null ) {
            currentScene = nextScene;

            if (uiSettings.getFadeScenes() && !firstScene) {
                utils.FadePanel pane = new utils.FadePanel(new BorderLayout());
                // takes mouse input, so u cant press stuff while fading
                pane.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        e.consume();
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        e.consume();
                    }
                });
                pane.setBackground(new Color(0,0,0));
                pane.setFaddedOut();
                pane.addFadeListener(new utils.FaderListener() {
                        @Override
                        public void fadeDidComplete(utils.FadePanel pane) {
                            if (pane.getAlpha() == 1) {
                                pane.fadeOut();
                                canvas.setBgImg(currentScene.getBgImg());
                                canvas.setCharacters(currentScene.getCharacters());
                                if (partNeedsToChange)
                                    nextPart();
                            } else {
                                JPanel newPanel = new JPanel();
                                parentFrame.setGlassPane(newPanel);
                                newPanel.setVisible(false);
                                fadding = false;
                            }
                        }
                    });
                parentFrame.setGlassPane(pane);
                pane.setVisible(true);
                fadding = true;
                pane.fadeIn();
            } else {
                canvas.setBgImg(currentScene.getBgImg());
                canvas.setCharacters(currentScene.getCharacters());
                firstScene = false;
            }

        } else {
            System.out.println("game has been completed");
            //finished = true;
            currentScene = null;
        }
    }
    boolean partNeedsToChange = false;
    public void nextPart() {
        if (currentScene != null) {
            ScenePart part = currentScene.getParts().poll();
            if (part != null) {
                currentScenePart = part;
                part.changeUI(this);
                part.onLoad(this);
            } else {
                partNeedsToChange = true;
                nextScene();
                //nextPart();
            }
        }
    }

    public GameCanvas getCanvas() {
        return canvas;
    }

    public T getData(){
        return dataStore;
    }

    public JPanel getCenterPanel() { return centerPanel; }

    public JPanel getBottomPanel() { return bottomPanel; }

}
