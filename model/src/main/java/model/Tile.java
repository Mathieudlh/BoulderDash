package model;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public abstract class Tile implements Tileable{

    protected Image image;

    private int TILE_SIZE = 32;

    public static Tile[] tiles = new Tile[10];
    public static Tile rock = new Rock();
    public static Tile diamond = new Diamond();
    public static Tile wall = new Wall();
    public static Tile dirt = new Dirt();

    public Tile(){

        image = new Image() {
            @Override
            public int getWidth(ImageObserver observer) {
                return 0;
            }

            @Override
            public int getHeight(ImageObserver observer) {
                return 0;
            }

            @Override
            public ImageProducer getSource() {
                return null;
            }

            @Override
            public Graphics getGraphics() {
                return null;
            }

            @Override
            public Object getProperty(String name, ImageObserver observer) {
                return null;
            }
        };
    }
}
