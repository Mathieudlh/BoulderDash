package model;

/**
 * Created by mathi on 21/06/2017.
 */


import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Assets {

    public Tile[] tiles = new Tile[];
    public static Tile wallTile = new WallTile(0);
    public static Tile rockTile = new RockTile(1);

}
