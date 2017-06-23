package model;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Rock extends Tile implements Fallable{

    /**
     * Tile number
     */
    public static final int TILE_NUMBER = 3;

    /**
     * @return int
     * returns the object's tile id
     */
    @Override
    public int getNumber() {
        return TILE_NUMBER;
    }

    @Override
    public boolean isFallable() {
        return true;
    }
}
