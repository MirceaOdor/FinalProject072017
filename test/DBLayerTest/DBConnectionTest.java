package DBLayerTest;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Vlad Mataoanu on 10.05.2017.
 */
class DBConnectionTest {
    DBConnection dbConnection = null;

    @Before
    void setup(){
        dbConnection = new DBConnection();
    }

    @Test
    void getDBcon() {

        dbConnection = new DBConnection();
        try {
            Connection con = dbConnection.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}