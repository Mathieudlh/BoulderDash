package model;

import java.awt.image.BufferedImage;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public interface Entityable {

    /**
     * @return int
     */
    int getX();

    /**
     * @return int
     */
    int getY();

    /**
     * @param x
     */
    void setX(int x);

    /**
     * @param y
     */
    void setY(int y);

    /**
     * @return boolean
     */
    boolean getIsAlive();

    /**
     * @param isAlive
     */
    void setIsAlive(boolean isAlive);

    /**
     * @return boolean
     */
    boolean isPlayer();

    /**
     *
     */
    void move();

    /**
     * @param direction
     */
    void setDirection(Direction direction);

    /**
     * @return Direction
     */
    Direction getDirection();

    /**
     * @return BufferedImage
     */
    BufferedImage getImage();
}
