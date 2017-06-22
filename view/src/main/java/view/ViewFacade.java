package view;

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
     * GameFrame
     */
    GameFrame gameframe;

    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() {
        super();
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
     * Draw the map
     * @param image
     */
    @Override
    public void drawMap(BufferedImage image) {
        gameframe.setImageMap(image);
    }

    /**
     * Draw the player
     * @param image
     */
    @Override
    public void drawPlayer(BufferedImage image) {
        gameframe.setImagePlayer(image);
    }

    /**
     * Create the window
     *
     * @param width
     * @param height
     */
    @Override
    public void createWindow(int width, int height) {
        gameframe = new GameFrame("Boulder Dash", width, height);
    }

}
