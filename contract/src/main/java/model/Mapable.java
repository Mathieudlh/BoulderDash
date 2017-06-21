package model;

import java.awt.image.BufferedImage;

/**
 * Created by doz Grou on 19/06/2017.
 */
public interface Mapable {

    BufferedImage getImage();
    void setImage(BufferedImage image);

    Tileable[][] getTiles();

    int getWidth();

    int getHeight();

}
