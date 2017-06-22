package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Player extends Entity implements Playable {

    /**
     * Image
     */
    private BufferedImage image;

    /**
     * Constructor
     */
    public Player() {
        try {
            image = ImageIO.read(new File("res/textures/player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return boolean
     */
    @Override
    public boolean isPlayer() {
        return true;
    }

    /**
     * Move
     */
    @Override
    public void move() {

    }

    /**
     * @return BufferedImage
     */
    @Override
    public BufferedImage getImage() {
        return this.image;
    }
}
