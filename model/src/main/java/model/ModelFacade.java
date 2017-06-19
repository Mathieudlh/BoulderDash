package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.ExampleDAO;

import javax.swing.text.html.parser.*;
import javax.swing.text.html.parser.Entity;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ModelFacade implements IModel {

    private Map map;
    protected Entity entity;

    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
        super();

        map = new Map();
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
    public void addEntity(Entityable entity) {

    }

    @Override
    public ArrayList<Entityable> getEntities() {
        return null;
    }

    public Map getMap() {
        return map;
    }

    public Entity getEntity() {
        return this.entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
