package Test;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;

/**
 * Created by Mircea on 30-Mar-17.
 */
public class Maine {

    public static void main(String[] av) {
        String dbURL = "jdbc:sqlserver://kraka.ucn.dk:1433;databaseName=dmaj0916_197290";
        try {
            // Load the jdbc-odbc bridge driver
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            // Enable logging
            DriverManager.setLogWriter(new PrintWriter((System.err)));

            System.out.println("Getting Connection");
            Connection conn = DriverManager.getConnection(dbURL, "dmaj0916_197290", "Password1!"); // user,
            // passwd

            // If a SQLWarning object is available, print its
            // warning(s). There may be multiple warnings chained.

            SQLWarning warn = conn.getWarnings();
            while (warn != null) {
                System.out.println("SQLState: " + warn.getSQLState());
                System.out.println("Message:  " + warn.getMessage());
                System.out.println("Vendor:   " + warn.getErrorCode());
                System.out.println("");
                warn = warn.getNextWarning();
            }

            // Do something with the connection here...

            conn.close(); // All done with that DB connection

        } catch (ClassNotFoundException e) {
            System.out.println("Can't load driver " + e);
        } catch (SQLException e) {
            System.out.println("Database access failed " + e);
        }
    }
}
