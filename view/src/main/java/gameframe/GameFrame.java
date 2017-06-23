package gameframe;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Created by mathi on 20/06/2017.
 */
public class GameFrame extends JFrame implements KeyListener {

    /**
     * GamePanel
     */
    private GamePanel gamePanel;
    private EventPerformerable eventPerformer;

    /**
     * Constructor
     *
     * @param title
     * @param width
     * @param height
     */
    public GameFrame(String title, EventPerformerable eventPerformer/*, IGraphicsBuilder graphicsBuilder, Observable observable*/, int width, int height) {

        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(this);

        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);

        this.eventPerformer = eventPerformer;

        gamePanel = new GamePanel(/*graphicsBuilder*/);
        gamePanel.setDoubleBuffered(true);
        //observable.addObserver(gamePanel);

        this.setContentPane(gamePanel);

        this.setVisible(true);
    }

    /**
     * @param keyEvent
     */
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    /**
     * get the key pressed by the user in order
     * @param keyEvent
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        this.eventPerformer.eventPerform(keyEvent);
    }

    /**
     * @param keyEvent
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    /**
     * set the correct image of the map
     * @param image
     */
    public void setImageMap(BufferedImage image) {
        this.gamePanel.setImageMap(image);
    }

    /**
     * @param imagePlayer
     */
    public void setImagePlayer(BufferedImage imagePlayer, int x, int y) {
        this.gamePanel.setImagePlayer(imagePlayer, x, y);
    }

    public void setScore(String score) {
        this.gamePanel.setScore(score);
    }
}
