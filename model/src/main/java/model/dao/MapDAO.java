package model.dao;

import model.Enemy;
import model.Enemyable;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Utilisateur on 21/06/2017.
 */
public abstract class MapDAO extends AbstractDAO {

    /**
     * Constructor
     */
    public MapDAO() {}

    /**
     * Read the map from DB
     * @param id
     * @return
     * @throws SQLException
     * Is used to read a DB field by executing a stocked procedure
     */
    public static String readMap(int id) throws SQLException {

        final CallableStatement callStatementMapCode = prepareCall("{call callMap(?)}");
        String mapCode = "";
        callStatementMapCode.setInt(1, id);
        if (callStatementMapCode.execute()) {
            final ResultSet result = callStatementMapCode.getResultSet();
            if (result.first()) {
                mapCode = result.getString(1);
            }
            result.close();
        }
        return mapCode;
    }

    private static ResultSet getPos(int id) throws SQLException {
        BoulderDashBDDConnector boulderDashBDD = BoulderDashBDDConnector.getInstance();
        Connection conn = boulderDashBDD.getConnection();
        Statement state = conn.createStatement();
        ResultSet result = state.executeQuery("CALL getPos(" + id + ")");
        //final CallableStatement callStatementGetPos = prepareCall("{call getPos(?)}");
        //callStatementGetPos.setInt(1, id);
        //final ResultSet result = callStatementGetPos.getResultSet();

        return result;
    }

    /**
     * @param id
     * @return
     * @throws SQLException
     */
    public static ArrayList<Enemyable> getEnemies(int id) throws SQLException {

        ResultSet result;
        ArrayList<Enemyable> enemies = null;
        result = MapDAO.getPos(id);
        if(result != null) {
            while (result.next()) {
                int x = result.getInt("pos_x");
                int y = result.getInt("pos_y");

                Enemyable enemy = new Enemy(x, y);

                enemies.add(enemy);

            }
        }
        return enemies;
    }
}
