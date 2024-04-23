package connecttojdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is used to connect and disconnect from the database
 * @author NMCG
 * @since 22/4/24
 * @see DBCommand
 */
public class DBConnect {
    
    private int portNumber;
    
    /**
     * This method is used to connect to the database
     * @param url URL of the database
     * @param dbName Name of the database
     * @param userName User name of the database
     * @param password Password of the database
     * @return Connection object
     */
    public static Connection connect(String url,
            String dbName, String userName,
            String password)
    {
    
        Connection conn = null;       
         try{
     
          conn = DriverManager.getConnection(url + dbName, userName, password);
      }
      catch(SQLException e){
          System.out.println(e.getMessage());
      }       
      return conn; 
    }
    
    /**
     * This method is used to disconnect from the database
     * @param conn Connection object
     * @return boolean 
     */
    public static boolean disconnect(Connection conn){

      try {
          conn.close();
          return true;
      } 
      catch (SQLException e) {
          System.out.println(e.getMessage());
      }
      
      return false;
    }

    
    
}
