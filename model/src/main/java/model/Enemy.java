package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Enemy extends Entity{

    private BufferedImage image;

    /**
     * @param x
     * @param y
     */
    public Enemy(int x, int y){
        super(x,y);

        try {
            image = ImageIO.read(new File("res/textures/tileset.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return BufferedImage
     */
    @Override
    public BufferedImage getImage() {
        return image.getSubimage(9 * 16, 0, 16, 16);
    }

    /**
     * @return boolean
     */
    @Override
    public boolean isPlayer() {
        return false;
    }

    /**
     *
     */
    @Override
    public void move() {

    }
}
