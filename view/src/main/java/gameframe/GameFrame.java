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

    /**
     * Constructor
     *
     * @param title
     * @param width
     * @param height
     */
    public GameFrame(String title/*, IEventPerformer Performer, IGraphicsBuilder graphicsBuilder, Observable observable*/, int width, int height) {

        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(this);


        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);

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
     * @param keyEvent
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    /**
     * @param keyEvent
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    /**
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
}
