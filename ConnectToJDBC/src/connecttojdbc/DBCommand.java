
package connecttojdbc;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DBCommand {

    public static ResultSet execute(Connection conn,
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

    public static void showOutput(ResultSet resultSet) {
        
        try{
            while(resultSet.next())
            {
            System.out.println(resultSet.getInt("GameID"));
            System.out.println(resultSet.getString("GameName"));
            System.out.println(resultSet.getDate("ReleaseDate"));
            System.out.println(resultSet.getString("Genre"));
            }
            
          //  resultSet.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
