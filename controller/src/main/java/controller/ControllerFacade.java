package controller;

import model.*;
import view.IView;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController, OrderPerformerable {

    /**
     * The view.
     */
    private IView view;

    /**
     * The model.
     */
    private final IModel model;

    /**
     * State of the game
     */
    private boolean isGameOver;

    /**
     * Instantiates a new controller facade.
     *
     * @param model the model
     */
    public ControllerFacade(final IModel model) {
        super();
        this.model = model;
        this.isGameOver = false;

        this.buildMap();
    }

    public void setView(final IView view) {
        this.view = view;
    }

    /**
     * Start.
     *
     * @throws SQLException the SQL exception
     */
    public void start() throws SQLException {
        view.createWindow(this.getModel().getMap().getWidth() * 16, this.getModel().getMap().getHeight() * 16);

        this.gameLoop();

        //TODO game over
        System.out.println("Game over !");

        this.exitGame();
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }

    /**
     * The gameloop
     */
    private void gameLoop() {
        while (!isGameOver) {
            if (this.getModel().getEntities() != null) {
                for (Entityable entity : this.getModel().getEntities()) {
                    entity.move();
                }
            }

            if (!this.getModel().getPlayer().getIsAlive()) {
                toggleGameOver();
            }

            manageTileMoveable();
            manageCollision();

            this.render();
        }
    }

    /**
     * Toggle attribute isGameOver
     */
    private void toggleGameOver() {
        isGameOver = !isGameOver;
    }

    /**
     * Manage the collision
     */
    private void manageCollision() {
        Entityable player = this.getModel().getPlayer();
        Mapable map = this.getModel().getMap();

        if (player.getX() <= 0)
            player.setX(0);
        if (player.getX() >= map.getWidth() * 16)
            player.setX(map.getWidth() * 16 - 16);
        if (player.getY() <= 0)
            player.setY(0);
        if (player.getY() >= map.getHeight() * 16)
            player.setY(map.getHeight() * 16 - 16);

        int tileNum = map.getTile(player.getX() / 16, player.getY() / 16).getNumber();

        switch (player.getDirection()) {
            case UP:
                if (player.getY() >= 0) {
                    if (tileNum == 0 || tileNum == 3) {
                        player.setY(player.getY() + 16);
                    }
                }
                break;

            case DOWN:
                if (player.getY() < map.getHeight() * 16) {
                    if (tileNum == 0 || tileNum == 3) {
                        player.setY(player.getY() - 16);
                    }
                }
                break;

            case LEFT:
                if (player.getX() >= 0) {
                    if (tileNum == 0 || tileNum == 3) {
                        player.setX(player.getX() + 16);
                    }
                }
                break;

            case RIGHT:
                if (player.getX() < map.getWidth() * 16) {
                    if (tileNum == 0 || tileNum == 3) {
                        player.setX(player.getX() - 16);
                    }
                }
                break;
        }

        if (tileNum == 1 || tileNum == 4) {
            map.setTile(2, player.getX() / 16, player.getY() / 16);
            rebuildMap(2, player.getX(), player.getY());

            if (tileNum == 4) {
                map.setScore(map.getScore() + 1);
            }
        }

        if (tileNum == 6) {
            if (map.getScore() == this.getModel().getMap().getNbDiamond())
                toggleGameOver();
        }
    }

    /**
     * Manage tiles that is moveable
     */
    private void manageTileMoveable() {
        Mapable map = this.getModel().getMap();

        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                Tileable tile = map.getTile(x, y);
                if (tile.isFallable() && map.getTile(x, y + 1).getNumber() == 2) {
                    if (map.getTile(x, y + 1).getNumber() == 2) {
                        map.setTile(2, x, y);
                        map.setTile(tile.getNumber(), x, y + 1);
                        rebuildMap(2, x * 16, y * 16); //TODO move rebuild to Map
                        rebuildMap(tile.getNumber(), x * 16, (y + 1) * 16);
                    }
                }
            }
        }
    }

    /**
     * The method that build the map
     */
    private void buildMap() {
        Tileable[][] tiles = this.getModel().getMap().getTiles();
        BufferedImage tmp = new BufferedImage(this.getModel().getMap().getWidth() * 16, this.getModel().getMap().getHeight() * 16, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < this.getModel().getMap().getHeight(); i++) {
            for (int j = 0; j < this.getModel().getMap().getWidth(); j++) {
                int num = tiles[i][j].getNumber();

                int x = num % 12 * 16;
                int y = num / 12 * 16;

                BufferedImage tile = this.getModel().getTileset().getSubimage(x, y, 16, 16);

                Graphics g = tmp.getGraphics();
                g.drawImage(tile, j * 16, i * 16, null);
            }
        }

        this.getModel().getMap().setImage(tmp);
    }

    private void rebuildMap(int numTile, int x, int y) {
        Graphics g = this.getModel().getMap().getImage().getGraphics();

        int xT = numTile % 12 * 16;
        int yT = numTile / 12 * 16;

        g.drawImage(this.getModel().getTileset().getSubimage(xT, yT, 16, 16), x, y, null);
    }

    /**
     * Method that render the game
     */
    private void render() {
        this.getView().drawMap(this.getModel().getMap().getImage());

        if (this.getModel().getPlayer() != null) {
            Entityable player = this.getModel().getPlayer();

            if (player.getImage() != null) {
                this.getView().drawPlayer(player.getImage(), player.getX(), player.getY());
            }
        }

        this.getView().drawScore(this.getModel().getMap().getScore());
    }

    private void exitGame() {
        this.getView().closeWindow();
        System.exit(0);
    }

    /**
     * @param userOrder
     */
    @Override
    public void orderPerform(UserOrderable userOrder) {
        if (userOrder != null) {
            Direction direction = null;
            Entityable player = this.getModel().getPlayer();
            int x = player.getX();
            int y = player.getY();

            switch (userOrder.getOrder()) {
                case UP:
                    direction = Direction.UP;
                    player.setY(y - 16);
                    break;

                case DOWN:
                    direction = Direction.DOWN;
                    player.setY(y + 16);
                    break;

                case LEFT:
                    direction = Direction.LEFT;
                    player.setX(x - 16);
                    break;

                case RIGHT:
                    direction = Direction.RIGHT;
                    player.setX(x + 16);
                    break;

                case EXIT:
                    this.exitGame();
                    break;

                default:
                    direction = player.getDirection();
            }

            player.setDirection(direction);
        }
    }
}
