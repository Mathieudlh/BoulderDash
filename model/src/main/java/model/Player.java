package model;

import java.awt.*;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Player extends Entity implements Playable {

    private Image image;

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
    public Image getImage() {
        return this.image;
    }
}
