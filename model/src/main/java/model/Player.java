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
        this.setIsAlive(true);
        this.setX(16);
        this.setY(16);
        this.setDirection(Direction.DOWN);

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
        switch (direction) {
            case UP:
                return this.image.getSubimage(2 * 16, 5 * 16, 16, 16);

            case DOWN:
                return this.image.getSubimage(0 * 16, 5 * 16, 16, 16);

            case LEFT:
                return this.image.getSubimage(3 * 16, 5 * 16, 16, 16);

            case RIGHT:
                return this.image.getSubimage(1 * 16, 5 * 16, 16, 16);
        }
        return this.image;
    }
}
