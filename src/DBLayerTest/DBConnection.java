package DBLayerTest;
/**
 * Created by Mircea on 29-Mar-17.
 */

import java.sql.*;

public class DBConnection {



    private static final String  driver = "jdbc:sqlserver://kraka.ucn.dk:1433;databaseName=dmaj0916_197290";;
    private static final String  databaseName = ";databaseName=dmaj0916_197290";

    private static String  userName = "; user=dmaj0916_197290";
    private static String password = ";password=Password1!";

    private DatabaseMetaData dma;
    private static Connection con;

    // an instance of the class is generated
    private static DBConnection  instance = null;





    public DBConnection()
    {
        String url = driver + databaseName + userName + password;

        try{
            //load of driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver class loaded ok");

        }
        catch(Exception e){
            System.out.println("Cannot find the driver");
            System.out.println(e.getMessage());
        }
        try{
            //connection to the database
            con = DriverManager.getConnection(url);
            con.setAutoCommit(true);
            dma = con.getMetaData(); // get meta data
            System.out.println("Connection to " + dma.getURL());
            System.out.println("Driver " + dma.getDriverName());
            System.out.println("Database product name " + dma.getDatabaseProductName());
        }//end try
        catch(Exception e){
            System.out.println("Problems with the connection to the database:");
            System.out.println(e.getMessage());
            System.out.println(url);
        }//end catch
    }//end  constructor


    public static void closeConnection()
    {
        try{
            con.close();
            instance= null;
            System.out.println("The connection is closed");
        }
        catch (Exception e){
            System.out.println("Error trying to close the database " +  e.getMessage());
        }
    }//end closeDB

    //getDBcon: returns the singleton instance of the DB connection
    public Connection getDBcon()
    {
        return con;
    }
    //getDBcon: returns the singleton instance of the DB connection
    public static boolean instanceIsNull()
    {
        return (instance == null);
    }
    //this method is used to get the instance of the connection
    public static DBConnection getInstance()
    {
        if (instance == null)
        {
            instance = new DBConnection();
        }
        return instance;
    }




}//end JDBCExample