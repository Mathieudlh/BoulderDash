package model;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Map {

    protected Tile tile;

    public Map(){
        tile = new Tile() {
            @Override
            public int getTileNumber() {
                return 0;
            }
        };
    }

    public Tile getTile(){
        return this.tile;
    }
    public void setTile(Tile tile){
        this.tile = tile;
    }
}
