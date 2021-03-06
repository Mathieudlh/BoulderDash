package model;

import model.dao.MapDAO;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ModelFacade implements IModel {

    /**
     * Map
     */
    private Map map;

    /**
     * Map ID
     */
    private int map_id;

    /**
     * Entities
     */
    private ArrayList<Entityable> entities;

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade(int map_id) {
        super();

        try {
            this.map_id = map_id;
            map = new Map(this.readMap(this.map_id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        entities = new ArrayList<>();
    }

    /**
     * @param id
     * @return MapDAO
     * @throws SQLException
     */
    @Override
    public String readMap(int id) throws SQLException {
        return MapDAO.readMap(id);
    }

    @Override
    public ArrayList<Enemyable> getEnemies(int id) throws SQLException {
        return MapDAO.getEnemies(id);
    }

    /**
     * @param entity
     */
    @Override
    public void addEntity(Entityable entity) {
        entities.add(entity);
    }

    /**
     * @return ArrayList<Entityable>
     */
    @Override
    public ArrayList<Entityable> getEntities() {
        return entities;
    }

    /**
     * @return Map
     */
    public Map getMap() {
        return map;
    }

    public int getMapID() {
        return map_id;
    }

    /**
     * @return Entityable
     */
    @Override
    public Entityable getPlayer() {
        for (Entityable entity : entities) {
            if (entity.isPlayer())
                return entity;
        }
        return null;
    }

    /**
     * @return BufferedImage
     */
    @Override
    public BufferedImage getTileset() {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File("res/textures/tileset.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

}
