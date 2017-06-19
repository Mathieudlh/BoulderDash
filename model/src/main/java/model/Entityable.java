package model;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public interface Entityable {

    Direction getDirection();
    void setDirection();
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
    boolean getIsAlive();
    void setIsAlive(boolean isAlive);
}
