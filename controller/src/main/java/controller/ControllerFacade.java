package controller;

import model.Direction;
import model.Entityable;
import model.IModel;
import model.Tileable;
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
    private final IView view;

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
     * @param view  the view
     * @param model the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
        this.isGameOver = false;

        this.buildMap();
    }

    /**
     * Start.
     *
     * @throws SQLException the SQL exception
     */
    public void start() throws SQLException {
        view.createWindow(this.getModel().getMap().getWidth() * 16, this.getModel().getMap().getHeight() * 16);
        gameLoop();
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
                    if (entity.isPlayer()) {
                        entity.move();
                    }
                }
            }

            if(!this.getModel().getPlayer().getIsAlive()) {
                isGameOver = !isGameOver;
            }

//            this.buildMap();
            this.render();
        }
    }

    /**
     * The method that build the map
     */
    private void buildMap() {
        Tileable[][] tiles = this.getModel().getMap().getTiles();
        BufferedImage tmp = new BufferedImage(this.getModel().getMap().getWidth() * 16, this.getModel().getMap().getHeight() * 16, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
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

    /**
     * Method that render the game
     */
    private void render() {
        this.getView().drawMap(this.getModel().getMap().getImage());

        if (this.getModel().getPlayer() != null) {
            Entityable player = this.getModel().getPlayer();

            if (player.getImage() != null) {
                this.getView().drawPlayer(player.getImage().getSubimage(0, 0, 16, 16), player.getX(), player.getY());
            }
        }
    }

    /**
     * @param userOrder
     */
    @Override
    public void orderPerform(UserOrderable userOrder) {
        if (userOrder != null) {
            Direction direction;
            Entityable player = this.getModel().getPlayer();
            int x = player.getX();
            int y = player.getY();

            switch (userOrder.getOrder()) {
                case UP:
                    direction = Direction.UP;
                    player.setY(y--);
                    break;

                case DOWN:
                    direction = Direction.DOWN;
                    player.setY(y++);
                    break;

                case LEFT:
                    direction = Direction.LEFT;
                    player.setX(x--);
                    break;

                case RIGHT:
                    direction = Direction.RIGHT;
                    player.setX(x++);
                    break;

                default:
                    direction = player.getDirection();
            }

            player.setDirection(direction);
        }
    }
}
