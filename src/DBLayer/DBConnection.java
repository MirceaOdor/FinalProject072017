package DBLayer;
import java.sql.*;
/**
 * Created by Mircea on 29-Mar-17.
 */
public class DBConnection {


    public static void main(String[] args) throws Throwable {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "dmaj0916_197290");
        connectionProps.put("password", "Password1!");
        conn = DriverManager.getConnection("jjdbc:sqlserver://kraka.ucn.dk:1433;databaseName=dmaj0916_197290", connectionProps);
        printAllMembers(conn);
        printAllDogs(conn);
        conn.close();
    }



}
