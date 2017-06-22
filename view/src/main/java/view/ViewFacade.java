package view;

import controller.OrderPerformerable;
import gameframe.GameFrame;

import javax.swing.*;
import java.awt.image.BufferedImage;


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

    /**
     * Draw the player from his image
     * @param image
     */
    @Override
    public void drawPlayer(BufferedImage image, int x, int y) {
        gameframe.setImagePlayer(image, x, y);
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

}
