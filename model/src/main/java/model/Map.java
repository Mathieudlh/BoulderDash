package model;

import java.awt.image.BufferedImage;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Map implements Mapable {

    /**
     * width
     */
    private int width = 0;

    /**
     * height
     */
    private int height = 0;

    /**
     * Tiles
     */
    private Tile[][] tiles;

    /**
     * Image
     */
    private BufferedImage image;

    /**
     * Constructor
     *
     * @param map
     */
    public Map(String map) {
        tiles = new Tile[height][width];
        image = new BufferedImage(width + 1, height + 1, BufferedImage.TYPE_INT_RGB);
        stringToTilesMap(map);
    }

    /**
     * String to tile map
     * reads the map string and separates each tile id
     * places all ids in a 2 dimensional table  using encapsulated "for" for x and y axis
     * this table represents the map and the tiles coordinates
     * @param str
     */
    private void stringToTilesMap(String str) {
        String[][] str_tmp = new String[1000][1000];
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

                    case Exit.TILE_NUMBER:
                        tiles[i][j] = new Exit();
                        break;

                    case Backdirt.TILE_NUMBER:
                        tiles[i][j] = new Backdirt();
                        break;
                }
            }
        }
    }

    /**
     * @param x
     * @param y
     * @return Tile
     */
    @Override
    public Tile getTile(int x, int y) {
        return this.tiles[y][x];
    }

    /**
     * @param tile
     * @param x
     * @param y
     */
    @Override
    public void setTile(Tileable tile, int x, int y) {
        this.tiles[y][x] = (Tile) tile;
    }

    /**
     * @return BufferedImage
     */
    @Override
    public BufferedImage getImage() {
        return image;
    }

    /**
     * @param image
     */
    @Override
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * @return Tileable[][]
     */
    @Override
    public Tileable[][] getTiles() {
        return tiles;
    }

    /**
     * @return int
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * @return int
     */
    @Override
    public int getHeight() {
        return height;
    }
}