package model;

import java.awt.image.BufferedImage;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public abstract class Tile implements Tileable {

    public static final int TILE_SIZE = 16;

    protected BufferedImage image;

    public Tile() {
        image = new BufferedImage(1, 1, 1);//TODO Temp
    }
}
