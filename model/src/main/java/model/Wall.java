package model;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Wall extends Tile{

    /**
     * Tile number
     */
    public static final int TILE_NUMBER = 0;

    /**
     * @return int
     * returns the object's tile id
     */
    @Override
    public int getNumber() {
        return TILE_NUMBER;
    }
}
