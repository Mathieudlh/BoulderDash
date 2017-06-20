package model;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public interface Entityable {

    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
    boolean getIsAlive();
    void setIsAlive(boolean isAlive);
    boolean isPlayer();
    void move();
    void setDirection(Direction direction);
    Direction getDirection();

}
