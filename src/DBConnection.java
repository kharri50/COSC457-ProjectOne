/**
 * Created by kyleharris on 9/5/17.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * This class acts as an object to perform database connectivity
 * functionality. The constructors will initiate a new database
 * connection via the JDBC drivers included in the external libraries.
 *
 */
public class DBConnection {


    private Connection conn; // database connection instance variable



    public void connectToDatabase(String cxn_url ,String username, String password) {
        try {
            // example db url : "jdbc:mysql://localhost/lahman2016";
            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            String DB_URL = cxn_url;
            this.conn = DriverManager.getConnection(DB_URL, username , password);
        } catch (Exception e) {
            // print the error
            System.out.println(e.getMessage());
        }
    }

    /** The following function returns a ResultSet object after the
     * SQL query has been run.
     */

    private ResultSet queryResult(String query) throws Exception{
        Statement stmt = this.conn.createStatement();
        return stmt.executeQuery(query);
    }

    /* The two functions work in conjunction - the private function doesn't contain any error handling, mainly
        because it doesn't need to. The public function will handle it if it arises.
     */

    public ResultSet executeQuery(String query){

        ResultSet rs;
        try{
            rs = this.queryResult(query);
        }catch(Exception e){
            //
            rs = null; // well rs isn't going to be anything if it's a bad query so init as null
            System.out.println(e.getMessage());
        }
        return rs;
    }



}

