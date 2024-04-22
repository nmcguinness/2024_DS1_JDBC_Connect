
package connecttojdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides MySQL connectivity functionality
 * @author NMCG
 * @version 1.0
 * @since 22/4/24
 * @see DBCommand
 */
public class DBConnect {
    
    /**
     * Connect to a remote MySQL database
     * @param url URL
     * @param dbName database name
     * @param userName user name with no spaces
     * @param password password with no spaces
     * @return valid MySQL connection object
     */
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
