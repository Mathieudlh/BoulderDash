package model;

import java.awt.image.BufferedImage;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public abstract class Entity implements Entityable {
    /**
     * x position
     */
    protected int x;

    /**
     * y position
     */
    protected int y;

    /**
     * isAlive
     */
    protected boolean isAlive;

    /**
     * Direction
     */
    protected Direction direction;

    /**
     *
     */
    public Entity() {

    }

    /**
     * @param x
     * @param y
     */
    public Entity(int x, int y) {
        this.x = x;
        this.y = y;

    }

    /**
     * @return int
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * @return int
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * @param x
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return boolean
     */
    @Override
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * @param isAlive
     */
    @Override
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    /**
     * @param direction
     */
    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @return Direction
     */
    @Override
    public Direction getDirection() {
        return direction;
    }

    /**
     * @return BufferedImage
     */
    @Override
    public abstract BufferedImage getImage();
}
