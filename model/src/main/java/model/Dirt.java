package model;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Dirt extends Tile implements Diggable{

    public static final int TILE_NUMBER = 1;

    @Override
    public int getNumber() {
        return TILE_NUMBER;
    }
}
