package model.dao;

import java.sql.*;

/**
 * Created by Utilisateur on 21/06/2017.
 */
public class mapDAO extends AbstractDAO{

    public mapDAO() {}

    BoulderDashBDDConnector BoulderDashBDD = BoulderDashBDDConnector.getInstance();
    Connection conn;
    ResultSet rs = null;
    Statement st = null;

    String SqlMap, SqlHeight, SqlWidth;

    public void setMap(int id){

        SqlMap = "CALL callMap("+id+")";
        SqlWidth = "CALL getWidth("+id+")";
        SqlHeight = "CALL getHeight("+id+")";
    }

    public String readMap(int id) throws SQLException {

        setMap(id);
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
