package view;

import model.Entityable;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IView {

    /**
     * Display message.
     *
     * @param message the message
     */
    void displayMessage(String message);

    /**
     * @param image
     */
    void drawMap(BufferedImage image);

    /**
     * @param entities
     */
    void drawEntities(ArrayList<Entityable> entities);

    /**
     * @param width
     * @param height
     */
    void createWindow(int width, int height);

    /**
     * Close the window
     */
    void closeWindow();

    /**
     * Draw the score
     * @param score
     */
    void drawScore(String score);
}
