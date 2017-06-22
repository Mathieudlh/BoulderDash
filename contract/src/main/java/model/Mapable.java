package model;

import java.awt.image.BufferedImage;

/**
 * Created by doz Grou on 19/06/2017.
 */
public interface Mapable {

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

}
