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
     * Score
     */
    private int score;

    private int nbDiamond;

    /**
     * Constructor
     *
     * @param map
     */
    public Map(String map) {
        tiles = new Tile[height][width];
        image = new BufferedImage(width + 1, height + 1, BufferedImage.TYPE_INT_RGB);
        score = 0;
        nbDiamond = 0;
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
                int tileNum = (int) str_tmp[i][j].charAt(0) - 48;

                convertNumToTile(tileNum, j, i);
                if(tileNum == Diamond.TILE_NUMBER)
                    nbDiamond++;
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

    @Override
    public void setTile(int tileNum, int x, int y) {
        convertNumToTile(tileNum, x, y);
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

    /**
     * @param tileNum
     * @param x
     * @param y
     */
    private void convertNumToTile(int tileNum, int x, int y) {
        switch (tileNum) {
            case Diamond.TILE_NUMBER:
                tiles[y][x] = new Diamond();
                break;

            case Dirt.TILE_NUMBER:
                tiles[y][x] = new Dirt();
                break;

            case Rock.TILE_NUMBER:
                tiles[y][x] = new Rock();
                break;

            case Wall.TILE_NUMBER:
                tiles[y][x] = new Wall();
                break;

            case Exit.TILE_NUMBER:
                tiles[y][x] = new Exit();
                break;

            case Backdirt.TILE_NUMBER:
                tiles[y][x] = new Backdirt();
                break;
        }
    }

    /**
     * @return
     */
    @Override
    public int getScore() {
        return score;
    }

    /**
     * @param score
     */
    @Override
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return
     */
    @Override
    public int getNbDiamond() {
        return nbDiamond;
    }
}