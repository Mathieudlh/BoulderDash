package model;

import java.awt.image.BufferedImage;

/**
 * Created by doz Grou on 19/06/2017.
 */
public interface Mapable {

    /**
     * @param x
     * @param y
     * @return
     */
    Tileable getTile(int x, int y);

    /**
     * @param x
     * @param y
     */
    void setTile(int tileNum, int x, int y);

    /**
     * @return BufferedImage
     */
    BufferedImage getImage();

    /**
     * @param image
     */
    void setImage(BufferedImage image);

    /**
     * @return Tileable[][]
     */
    Tileable[][] getTiles();

    /**
     * @return int
     */
    int getWidth();

    /**
     * @return int
     */
    int getHeight();

    /**
     * @return int
     */
    int getScore();

    /**
     * @param score
     */
    void setScore(int score);

    /**
     * @return int Number of diamond
     */
    int getNbDiamond();

}
