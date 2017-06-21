package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static model.dao.AbstractDAO.prepareCall;

/**
 * Created by Utilisateur on 21/06/2017.
 */
public class mapDAO {

    public static String readInDB(int id) throws SQLException {
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
    public void setMap(int id){

        SqlMap = "CALL callMap("+id+")";
        SqlWidth = "CALL getWidth("+id+")";
        SqlHeight = "CALL getHeight("+id+")";
    }

}
