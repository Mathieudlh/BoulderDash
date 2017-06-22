package model.dao;

import java.sql.*;

/**
 * Created by Utilisateur on 21/06/2017.
 */
public abstract class mapDAO extends AbstractDAO {

    BoulderDashBDDConnector BoulderDashBDD = BoulderDashBDDConnector.getInstance();
    Connection conn;
    ResultSet rs = null;
    Statement st = null;

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

}
