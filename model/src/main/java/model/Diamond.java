package model;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Diamond extends Tile implements Fallable{

    public static final int TILE_NUMBER = 4;

    @Override
    public int getNumber() {
        return TILE_NUMBER;
    }
}
