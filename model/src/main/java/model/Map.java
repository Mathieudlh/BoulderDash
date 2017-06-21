package model;

import java.awt.image.BufferedImage;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Map implements Mapable {

    private int width = 0, height = 0;
    private Tile[][] tiles;
    private BufferedImage image;

    public Map(String map) {
        tiles = new Tile[height][width];
        image = new BufferedImage(width + 1, height + 1, BufferedImage.TYPE_INT_RGB);
        stringToTilesMap(map);
    }

    private void stringToTilesMap(String str) {
        String[][] str_tmp = new String[500][500];
        String[] tmp = str.split("\n");
        height = tmp.length;

        for (int i = 0; i < tmp.length; i++) {
            String[] tmp2 = tmp[i].split(",");
            width = tmp2.length;

            for (int j = 0; j < tmp2.length; j++) {
                str_tmp[i][j] = tmp2[j];
            }
        }

        tiles = new Tile[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                switch ((int) str_tmp[i][j].charAt(0) - 48) {
                    case Diamond.TILE_NUMBER:
                        tiles[i][j] = new Diamond();
                        break;

                    case Dirt.TILE_NUMBER:
                        tiles[i][j] = new Dirt();
                        break;

                    case Rock.TILE_NUMBER:
                        tiles[i][j] = new Rock();
                        break;

                    case Wall.TILE_NUMBER:
                        tiles[i][j] = new Wall();
                        break;
                }
            }
        }
    }

    public Tile getTiles(int x, int y) {
        return this.tiles[x][y];
    }

    public void setTiles(Tile tile, int x, int y) {
        this.tiles[x][y] = tile;
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public Tileable[][] getTiles() {
        return tiles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}