package connecttojdbc;

import java.sql.Connection;
import java.sql.ResultSet;


/**
 * Demonstrates how to write object-oriented (i.e., use classes to bundle functionality) code in Java to connect to your DB
 * @author NMCG
 * @since 22/4/24
 */
public class Main {
    
     //some common setup variables (e.g., password, url, name, dbname)
     String url = "jdbc:mysql://localhost:3306/";
     String dbName = "2024_ds1_ca3_games"; //"your DB name goes here"
      
     //access related variables
     String userName = "root";
     String password = "";
     
     //store the connection to the DB
     Connection conn = null;
     

     public static void main(String[] args) {
         
        //create an instance of the Main class to call the non-static run() method
        new Main().run();
     }

     public void run() { 
         
      /************************* CONNECT *************************/
      
      //connect to DB
      conn = DBConnect.connect(url, dbName, userName, password);
      
            
      /************************* QUERY *************************/
      
      //specify the query
      String query = "SELECT * FROM games";
      
      //execute query
      ResultSet resultSet = DBCommand.executeQuery(conn, query);
           
      //show results
      DBOutputFormatter.showAllGames("Query: " + query, resultSet);
      
      /************************* QUERY *************************/
      
      //specify the query
      query = "SELECT Players.FirstName, PlayerGames.Score, Games.GameName "
              + "FROM Players "
              + "JOIN PlayerGames ON Players.PlayerID = PlayerGames.PlayerID "
              + "JOIN Games ON PlayerGames.GameID = Games.GameID "
              + "ORDER BY Players.FirstName ASC";
      
      //execute query
      resultSet = DBCommand.executeQuery(conn, query);
           
      //show results
      DBOutputFormatter.showAllScores("Query: " + query, resultSet);
      
            
      /************************* DISCONNECT *************************/
      
      //disconnect from DB
      DBConnect.disconnect(conn);

    }
     

 /*
  //an old version where we lumped all the code into the main() method
  public static void main(String[] args) {
      
      //setup some variables (e.g., password, url, name, dbname)
      String url = "jdbc:mysql://localhost:3306/";
      String dbName = "2024_ds1_ca3_games"; //any DB you have!
      
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
      
      try{
        //execute a query
        Statement statement = conn.createStatement();

        //form the query
        String query = "SELECT * FROM games"; //use your table name!

        //show the results
        ResultSet resultSet = statement.executeQuery(query);


        while(resultSet.next())
        {
        System.out.println(resultSet.getInt("GameID"));
        System.out.println(resultSet.getString("GameName"));
        System.out.println(resultSet.getDate("ReleaseDate"));
        System.out.println(resultSet.getString("Genre"));
        }
      }
      catch(SQLException e)
      {
          System.out.println(e.getMessage());
      }
        
       //close the connection  
      try {
          conn.close();
      } catch (SQLException ex) {
          Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }

    }
*/
    
}
