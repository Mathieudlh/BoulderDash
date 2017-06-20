package model;

import java.awt.*;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Enemy extends Entity{

    public Enemy(int x, int y){
        super(x,y);
    }

    @Override
    public boolean isPlayer() {
        return false;
    }

    @Override
    public void move() {

    }

    @Override
    public Image getImage(int id) {
        return null;
    }
}
