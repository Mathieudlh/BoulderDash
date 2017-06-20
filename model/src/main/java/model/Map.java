package model;

import java.awt.image.BufferedImage;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Map implements Mapable {

    protected Tile tile;
    private int width, height;
    private int [][] tiles;

    public Map(String path, int width, int height){
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

    @Override
    public BufferedImage getImage() {
        return null;
    }
}
