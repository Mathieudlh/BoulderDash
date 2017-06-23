package view;

import controller.OrderPerformerable;
import gameframe.GameFrame;
import model.Entityable;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {

    /**
     * Event performer
     */
    private EventPerformer eventPerformer;

    /**
     * GameFrame
     */
    GameFrame gameframe;

    /**
     * Instantiates a new view facade.
     */
    public ViewFacade(OrderPerformerable orderPerformer) {
        super();

        this.eventPerformer = new EventPerformer(orderPerformer);
    }

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Draw the map from its image
     * @param image
     */
    @Override
    public void drawMap(BufferedImage image) {
        gameframe.setImageMap(image);
    }

    @Override
    public void drawEntities(ArrayList<Entityable> entities) {
        gameframe.setEntities(entities);
    }

    /**
     * Create the window
     *
     * @param width
     * @param height
     */
    @Override
    public void createWindow(int width, int height) {
        gameframe = new GameFrame("Boulder Dash", eventPerformer, width, height);
    }

    @Override
    public void closeWindow() {
        gameframe.dispose();
    }

    @Override
    public void drawScore(String score) {
        gameframe.setScore(score);
    }

}
