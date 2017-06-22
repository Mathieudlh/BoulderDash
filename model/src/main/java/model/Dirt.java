package model;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Dirt extends Tile implements Diggable{

    /**
     * Tile number
     */
    public static final int TILE_NUMBER = 1;

    /**
     * @return int
     * returns the object's tile id
     */
    @Override
    public int getNumber() {
        return TILE_NUMBER;
    }
}
