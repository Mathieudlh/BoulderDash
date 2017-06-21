package controller;

import model.Direction;
import model.Entityable;
import model.IModel;
import view.IView;

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
        view.createWindow(1920, 1000);
    }

    /**
     * Start.
     *
     * @throws SQLException the SQL exception
     */
    public void start() throws SQLException {
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

    private void gameLoop() {
        while (!isGameOver) {

            if(this.getModel().getEntities() != null) {
                for (Entityable entity : this.getModel().getEntities()) {
                    if (entity.isPlayer())
                        entity.move();
                }
            }

            this.render();
        }
    }

    private void render() {
        this.getView().drawMap(this.getModel().getMap().getImage());

        if(this.getModel().getPlayer() != null)
            if(this.getModel().getPlayer().getImage() != null)
                this.getView().drawPlayer(this.getModel().getPlayer().getImage());
    }

    @Override
    public void orderPerform(UserOrderable userOrder) {
        if(userOrder != null) {
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
