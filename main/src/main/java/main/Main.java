package main;

import controller.ControllerFacade;
import model.Enemy;
import model.ModelFacade;
import model.Player;
import view.ViewFacade;

import java.sql.SQLException;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final ControllerFacade controller = new ControllerFacade(new ModelFacade(5));
        controller.setView(new ViewFacade(controller));

        controller.getModel().addEntity(new Player());

        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }

}
