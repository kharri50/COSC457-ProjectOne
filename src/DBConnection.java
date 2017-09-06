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



    public void connectToAndQueryDatabase(String username, String password) {

        try {

            Class.forName ("com.mysql.jdbc.Driver").newInstance ();
            String DB_URL = "jdbc:mysql://localhost/lahman2016";

            Connection conn = DriverManager.getConnection(DB_URL, "root", "Nnormann11!");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Appearances");

            System.out.println(rs.toString());
            while (rs.next()) {
                String s = rs.getString("yearID");
                System.out.println(s);
            }


        } catch (Exception e) {
            // print the error
        }
    }
}

