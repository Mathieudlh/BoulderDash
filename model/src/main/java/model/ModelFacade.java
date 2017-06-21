package model;

import model.dao.ExampleDAO;
import model.dao.mapDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ModelFacade implements IModel {

    private Map map;
    private ArrayList<Entityable> entities;

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();

        try {
            map = new Map(this.readMap(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        entities = new ArrayList<>();
    }

    /*
         * (non-Javadoc)
         * @see model.IModel#getExampleById(int)
         */
    @Override
    public Example getExampleById(final int id) throws SQLException {
        return ExampleDAO.getExampleById(id);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleByName(java.lang.String)
     */
    @Override
    public Example getExampleByName(final String name) throws SQLException {
        return ExampleDAO.getExampleByName(name);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getAllExamples()
     */
    @Override
    public List<Example> getAllExamples() throws SQLException {
        return ExampleDAO.getAllExamples();
    }

    @Override
    public String readMap(int id) throws SQLException {
        return mapDAO.readMap(id);
    }

    @Override
    public void addEntity(Entityable entity) {
        entities.add(entity);
    }

    @Override
    public ArrayList<Entityable> getEntities() {
        return entities;
    }

    public Map getMap() {
        return map;
    }

    @Override
    public Entityable getPlayer() {
        for(Entityable entity : entities) {
            if(entity.isPlayer())
                return entity;
        }
        return null;
    }

}
