package model.dao;

import java.sql.*;

/**
 * Created by Utilisateur on 21/06/2017.
 */
public abstract class mapDAO extends AbstractDAO {

    public mapDAO() {}

    BoulderDashBDDConnector BoulderDashBDD = BoulderDashBDDConnector.getInstance();
    Connection conn;
    ResultSet rs = null;
    Statement st = null;

    public static String readMap(int id) throws SQLException {

        final CallableStatement callStatementMapCode = prepareCall("{call callMap(?)}");
        String mapCode = "";
        callStatementMapCode.setInt(1, id);
        if (callStatementMapCode.execute()) {
            final ResultSet result = callStatementMapCode.getResultSet();
            if (result.first()) {
                mapCode = result.getString(1);
                System.out.println(mapCode);
            }
            result.close();
        }
        return mapCode;
    }


}
