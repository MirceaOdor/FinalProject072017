import DBLayer.DBConnection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Vlad Mataoanu.
 */
public class DBConnectionTest {
    DBConnection connection=null;

    @Before
    public void initialize() throws Exception{
        connection = DBConnection.getInstance();
    }
    @Test
    public void test() throws Exception{
        assertNotNull("Connected - connection cannot be null", connection);

        DBConnection.closeConnection();
        boolean wasNullified = DBConnection.instanceIsNull();
        assertTrue("Disconnected - instance set to null", wasNullified);

        connection = DBConnection.getInstance();
        assertNotNull("Connected - connection cannot be null", connection);
    }

    @After
    public void closeCOnn() throws Exception{
        DBConnection.closeConnection();
    }
}