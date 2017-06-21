package model;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

    String readMap(int id) throws SQLException;

    void addEntity(Entityable entity);

    ArrayList<Entityable> getEntities();

    Mapable getMap();

    Entityable getPlayer();

    BufferedImage getTileset();
}
