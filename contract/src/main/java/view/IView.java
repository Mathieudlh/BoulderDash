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

    void drawMap(BufferedImage image);

    void drawPlayer(BufferedImage image);
}
