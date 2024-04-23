package connecttojdbc;

import java.sql.Connection;
import java.sql.ResultSet;


public class Main {
    
      //some common setup variables (e.g., password, url, name, dbname)
      String url = "jdbc:mysql://localhost:3306/";
      String dbName = "2024_ds1_ca3_games"; //"your DB name goes here"
      
      String userName = "root";
      String password = "";
      Connection conn = null;

     public static void main(String[] args) {
         
        //create an instance of the Main class to call the non-static run() method
        new Main().run();
     }

     public void run() { 
         
      //connect to DB
      conn = DBConnect.connect(url, dbName, userName, password);
      
      //specify the query
      String query = "SELECT * FROM games";
      
      //execute query
      ResultSet resultSet = DBCommand.executeQuery(conn, query);
           
      //show results
      DBOutputFormatter.showAllGames("Query: SELECT * FROM games...", resultSet);
      
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
