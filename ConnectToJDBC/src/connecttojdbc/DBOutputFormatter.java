
package connecttojdbc;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to format and output the result of each query run on the database.
 * @author NMCG
 * @since 22/4/24
 * @see Main
 */
public class DBOutputFormatter {
    
    /**
     * This method is used to show the output of the query "SELECT * FROM games"
     * @param resultSet ResultSet object
     * @return int row count
     */
    public static int showAllGames(String title, ResultSet resultSet)
    {
        if(resultSet == null)
        {
            System.out.println("No results were returned!");
            return -1;
        }
        
        int rowCount = 0;

        //print header
        System.out.println("");
        System.out.println(title);  
        System.out.println("");
        System.out.println("Game ID\t\t\tGame Name\t\tRelease Date\t\t\tGenre");
        System.out.println("-------\t\t\t---------\t\t------------\t\t\t-----");
        
        //print results
        try{
            while(resultSet.next())
            {
                rowCount++;
                
                System.out.print(resultSet.getInt("GameID"));
                System.out.print("\t\t\t");
                
                System.out.print(resultSet.getString("GameName"));
                System.out.print("\t\t");
                
                System.out.print(resultSet.getDate("ReleaseDate"));
                System.out.print("\t\t\t");
                
                System.out.print(resultSet.getString("Genre"));
                System.out.print("\n");
                
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        //return the number of rows output
        return rowCount;
    }

    public static int showAllScores(String title, ResultSet resultSet) {
        
        if(resultSet == null)
        {
            System.out.println("No results were returned!");
            return -1;
        }
        
        int rowCount = 0;

        //print header
        System.out.println("");
        System.out.println(title);
        System.out.println("");
        System.out.println("FirstName\tScore\t\tGameName");
        System.out.println("---------\t-----\t\t------");
        
        //print results
        try{
            while(resultSet.next())
            {
                rowCount++;
  
              
                System.out.print(resultSet.getString("FirstName"));
                System.out.print("\t\t");
                
                System.out.print(resultSet.getInt("Score"));
                System.out.print("\t\t");
                
                System.out.print(resultSet.getString("GameName"));

                System.out.print("\n");
                
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        //return the number of rows output
        return rowCount;
    }
}

