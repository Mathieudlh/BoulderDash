package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Player extends Entity implements Playable {

    private BufferedImage image;

    public Player() {
        try {
            image = ImageIO.read(new File("res/textures/player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public void move() {

    }

    @Override
    public BufferedImage getImage() {
        return this.image;
    }
}
