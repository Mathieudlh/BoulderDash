package gameframe;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Created by mathi on 20/06/2017.
 */
public class GameFrame extends JFrame implements KeyListener {

    private GamePanel gamePanel;

    public GameFrame(String title/*, IEventPerformer Performer, IGraphicsBuilder graphicsBuilder, Observable observable*/, int width, int height) {

        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(this);


        this.setSize(width, height);
        this.setLocationRelativeTo(null);

        gamePanel = new GamePanel(/*graphicsBuilder*/);
        gamePanel.setDoubleBuffered(true);
        //observable.addObserver(gamePanel);

        this.setContentPane(gamePanel);

        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public void setImageMap(BufferedImage image) {
        this.gamePanel.setImageMap(image);
    }
}
