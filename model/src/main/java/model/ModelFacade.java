package model;

import model.dao.mapDAO;

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
     * Entities
     */
    private ArrayList<Entityable> entities;

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();

        try {
            map = new Map(this.readMap(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        entities = new ArrayList<>();
    }

    /**
     * @param id
     * @return mapDAO
     * @throws SQLException
     */
    @Override
    public String readMap(int id) throws SQLException {
        return mapDAO.readMap(id);
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
