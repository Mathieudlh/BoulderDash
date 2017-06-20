package model;

import java.awt.image.BufferedImage;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Map implements Mapable {

    private int width, height;
    private Tile[][] tiles;

    public Map(String path, int width, int height) {
        tiles = new Tile[width][height];
        this.width = width;
        this.height = height;
    }

    public Tile getTiles(int x, int y) {
        return this.tiles[x][y];
    }

    public void setTiles(Tile tile, int x, int y) {
        this.tiles[x][y] = tile;
    }

    @Override
    public BufferedImage getImage() {
        return null;
    }
}
