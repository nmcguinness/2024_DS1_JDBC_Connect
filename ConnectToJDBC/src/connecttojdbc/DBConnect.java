
package connecttojdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    

    public Connection connect(String url,
            String dbName, String userName,
            String password)
    {
        Connection conn = null;       
         try{
          conn = DriverManager.getConnection(url + dbName,
                  userName, password);
      }
      catch(SQLException e){
          System.out.println(e.getMessage());
      }       
      return conn; 
    }
    
    //disconnect
    
}
