package model;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Player extends Entity implements Playable {

    private BufferedImage image;

    public Player(){

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
