package view;

import java.awt.image.BufferedImage;

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
     * @param image
     */
    void drawPlayer(BufferedImage image, int x, int y);

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
