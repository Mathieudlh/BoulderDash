package model;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

    /**
     * @param id
     * @return String
     * @throws SQLException
     */
    String readMap(int id) throws SQLException;

    ArrayList<Enemyable> getEnemies(int id) throws SQLException;

    /**
     * @param entity
     */
    void addEntity(Entityable entity);

    /**
     * @return ArrayList<Entityable>
     */
    ArrayList<Entityable> getEntities();

    /**
     * @return Mapable
     */
    Mapable getMap();

    /**
     * @return Map ID
     */
    int getMapID();

    /**
     * @return Entityable
     */
    Entityable getPlayer();

    /**
     * @return BufferedImage
     */
    BufferedImage getTileset();
}
