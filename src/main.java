/**
 * Created by Kyle Harris on 9/5/17.
 */

public class main {
    public static void main (String [] args){
        // function just tests the database connectivity

        DBConnection dbc = new DBConnection();
        dbc.connectToAndQueryDatabase("root", "Nnormann11!");
    }
}
