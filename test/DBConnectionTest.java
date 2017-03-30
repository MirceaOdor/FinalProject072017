/**
 * Created by Mircea on 30-Mar-17.
 */

import static org.junit.Assert.*;
public class DBConnectionTest {

    DBConnection con = null;
    static PBuy tempPBuy;

    /** Fixture for pay station testing. */



    @Test
    public void wasConnected() {
        assertNotNull("Connected - connection cannot be null", con);

        DBConnection.closeConnection();
        boolean wasNullified = DBConnection.instanceIsNull();
        assertTrue("Disconnected - instance set to null", wasNullified);

        con = DBConnection.getInstance();
        assertNotNull("Connected - connection cannot be null", con);
    }

}
