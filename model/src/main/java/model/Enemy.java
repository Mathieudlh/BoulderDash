package model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Utilisateur on 16/06/2017.
 */
public class Enemy extends Entity implements Enemyable {

    /**
     * Image of the enemy
     */
    private BufferedImage image;

    /**
     * Timer
     */
    private long elapsed;

    /**
     * @param x
     * @param y
     */
    public Enemy(int x, int y) {
        super(x, y);

        try {
            image = ImageIO.read(new File("res/textures/tileset.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setDirection(Direction.DOWN);
        elapsed = 0;
    }

    /**
     * @return BufferedImage
     */
    @Override
    public BufferedImage getImage() {
        return image.getSubimage(9 * 16, 0, 16, 16);
    }

    /**
     * @return boolean
     */
    @Override
    public boolean isPlayer() {
        return false;
    }

    /**
     *
     */
    @Override
    public void move(Mapable map) {
        long nanoTime = System.nanoTime();
        if(nanoTime - elapsed >= 500000000) { //=500ms
            elapsed = System.nanoTime();

            switch (direction) {
                case UP:
                    y = y - 16;
                    break;

                case DOWN:
                    y = y + 16;
                    break;

                case LEFT:
                    x = x - 16;
                    break;

                case RIGHT:
                    x = x + 16;
                    break;
            }

            manageCollision(map);
        }
    }

    /**
     * @param map
     */
    private void manageCollision(Mapable map) {
        if (this.getX() <= 0)
            this.setX(0);
        if (this.getX() >= map.getWidth() * 16)
            this.setX(map.getWidth() * 16 - 16);
        if (this.getY() <= 0)
            this.setY(0);
        if (this.getY() >= map.getHeight() * 16)
            this.setY(map.getHeight() * 16 - 16);

        int tileNum = map.getTile(this.getX() / 16, this.getY() / 16).getNumber();

        switch (this.getDirection()) {
            case UP:
                if (this.getY() >= 0) {
                    if (tileNum == 0 || tileNum == 1 || tileNum == 3) {
                        this.setY(this.getY() + 16);
                        setDirection(Direction.RIGHT);
                    }
                }
                break;

            case DOWN:
                if (this.getY() < map.getHeight() * 16) {
                    if (tileNum == 0 || tileNum == 1 || tileNum == 3) {
                        this.setY(this.getY() - 16);
                        setDirection(Direction.LEFT);
                    }
                }
                break;

            case LEFT:
                if (this.getX() >= 0) {
                    if (tileNum == 0 || tileNum == 1 || tileNum == 3) {
                        this.setX(this.getX() + 16);
                        setDirection(Direction.UP);
                    }
                }
                break;

            case RIGHT:
                if (this.getX() < map.getWidth() * 16) {
                    if (tileNum == 0 || tileNum == 1 || tileNum == 3) {
                        this.setX(this.getX() - 16);
                        setDirection(Direction.DOWN);
                    }
                }
                break;
        }

        /*for(int i = 0; i <= 4; i++) {
            switch (direction) {
                case UP:
                    switch (tiles[(y - 1) / 16][x / 16].getNumber()) {
                        case 0:
                        case 1:
                        case 3:
                            setDirection(Direction.RIGHT);
                            break;
                    }
                    break;

                case DOWN:
                    switch (tiles[(y + 1) / 16][x / 16].getNumber()) {
                        case 0:
                        case 1:
                        case 3:
                            setDirection(Direction.LEFT);
                            break;
                    }
                    break;

                case LEFT:
                    switch (tiles[y / 16][(x - 1) / 16].getNumber()) {
                        case 0:
                        case 1:
                        case 3:
                            setDirection(Direction.UP);
                            break;
                    }
                    break;

                case RIGHT:
                    switch (tiles[y / 16][(x + 1) / 16].getNumber()) {
                        case 0:
                        case 1:
                        case 3:
                            setDirection(Direction.DOWN);
                            break;
                    }
                    break;
            }
        }*/
    }
}
