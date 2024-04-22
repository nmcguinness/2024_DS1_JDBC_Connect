
package connecttojdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
    
    //no member variables - no state
   // private string someUsefulVar;
   // private int connectSpeed;
    

    public static Connection connect(String url,
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
    public static boolean disconnect(Connection conn){

      try {
          conn.close();
          return true;
      } 
      catch (SQLException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      return false;
    }

    
    
}
