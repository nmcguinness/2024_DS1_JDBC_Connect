
package connecttojdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

  public static void main(String[] args) {
      
      //setup some variables (e.g., password, url, name, dbname)
      String url = "jdbc:mysql://localhost:3306/";
      String dbName = "2023_ds1_ca3_games"; //any DB you have!
      
      String userName = "root";
      String password = "";
      
      Connection conn = null;
      
      try{
          //open a connection
          conn = DriverManager.getConnection(url + dbName,
                  userName, password);
      }
      catch(SQLException e){
          System.out.println(e.getMessage());
      }
      catch(Exception e)
      {
          System.out.println(e.getMessage());
          System.out.println("I dont know but something bad happened!");
      }
      
      //execute a query
          
      //show the results
          
      //close the connection  
        
      try {
          conn.close();
      } catch (SQLException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }

      
      
        
    }
    
}
