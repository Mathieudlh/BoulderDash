package model;

import java.sql.SQLException;
import java.util.*;

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
    private ArrayList<Entity> entities = new ArrayList<Entity>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Entity> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Entity entity) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Entity> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Entity> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Entity get(int index) {
            return null;
        }

        @Override
        public Entity set(int index, Entity element) {
            return null;
        }

        @Override
        public void add(int index, Entity element) {

        }

        @Override
        public Entity remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Entity> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Entity> listIterator(int index) {
            return null;
        }

        @Override
        public List<Entity> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

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

}
