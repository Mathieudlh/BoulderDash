package controller;

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
public class ControllerFacade implements IController {

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

            this.getView().displayMessage("Message");

            for (Entityable entity : this.getModel().getEntities()) {
                if (entity.isPlayer())
                    entity.move();
            }

            this.render();
        }
    }

    private void render() {
        this.getView().drawMap(this.getModel().getMap().getImage());
    }
}
