package model;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public abstract class Entity implements Entityable {
    protected int x;
    protected int y;
    private boolean isAlive;
    private Direction direction;

    protected ModelFacade modelFacade;

    public Entity(int x, int y){
        this.x = x;
        this.y = y;

    }

    public Entity(){

    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public boolean getIsAlive(){
        return isAlive;
    }
    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public ModelFacade getModelFacade(){
        return this.modelFacade;
    }

    public void setModelFacade(ModelFacade modelFacade){
        this.modelFacade = modelFacade;
    }

    public abstract BufferedImage getImage();
}
