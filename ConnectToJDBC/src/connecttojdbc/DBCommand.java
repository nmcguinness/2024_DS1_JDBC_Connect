
package connecttojdbc;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * This class is used to execute the query and show the output
 * @author NMCG
 * @since 22/4/24
 * @see DBConnect
 */
public class DBCommand {

    /**
     * This method is execute a SELECT query on the SQL DB
     * @param conn Connection object
     * @param query query to be executed
     * @return ResultSet object
     */
    public static ResultSet executeQuery(Connection conn,
            String query) {
        
        ResultSet resultSet = null;
        try{
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return resultSet;
    } 

    /**
     * This method is execute an INSERT, UPDATE, or DELETE query on the SQL DB
     * @param resultSet ResultSet object
     * @return int row count updated
     */
    public static int executeUpdate(Connection conn, String query) {
        int result = 0;
        try{
            Statement statement = conn.createStatement();
            result = statement.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
