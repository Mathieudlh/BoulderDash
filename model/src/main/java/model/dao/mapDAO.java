package model.dao;

import model.Enemy;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Utilisateur on 21/06/2017.
 */
public abstract class mapDAO extends AbstractDAO {

    /**
     * Constructor
     */
    public mapDAO() {}

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
        final CallableStatement callStatementGetPos = prepareCall("{call getPos(?)}");
        callStatementGetPos.setInt(1, id);
        final ResultSet result = callStatementGetPos.getResultSet();

        return result;
    }
}
