import java.util.ArrayList;
import java.sql.ResultSet;

/**
 * Created by Kyle Harris on 9/5/17.
 */

public class main {
    public static void main (String [] args){
        // function just tests the database connectivity



        String url  = "jdbc:mysql://18.220.133.85:3306/exsurfacepro";
        String user =  "root";
        String password = "cosc457!";
        DBConnection dbc = new DBConnection();
        dbc.connectToDatabase(url, user, password);

        // the DBConnection class only handles the connection and the queries. It doesn't parse the result sets


        String query = "SELECT * FROM test_users";
        //Just a simple test for the ResultReader class
        // ResultSet r  = dbc.executeQuery("SELECT * FROM teams;");
        ResultReader reader = new ResultReader(dbc.executeQuery(query));

        // code snippet will iterate the arraylist
        ArrayList<String> columns = reader.getColumns();
        for(String col : columns){
            System.out.println(col);
        }



    }
}
