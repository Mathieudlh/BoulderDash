package model;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Enemy extends Entity{

    public Enemy(int x, int y){
        super(x,y);
    }

    @Override
    public BufferedImage getImage() {
        return null;
    }

    @Override
    public boolean isPlayer() {
        return false;
    }

    @Override
    public void move() {

    }
}
