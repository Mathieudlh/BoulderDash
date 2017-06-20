package model;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Player extends Entity implements Playable {

    public Player(){

    }
    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public void move() {

    }
}
