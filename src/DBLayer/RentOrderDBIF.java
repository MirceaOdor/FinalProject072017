package DBLayer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  RentOrderDBIF {

    RentOrder create (String id, String barcode, int quantity, java.util.Date start_Day, int duration, String personalID) throws SQLException;
    RentOrder update (int id, String object, int index) throws SQLException;
    boolean delete (int id) throws SQLException;
    RentOrder readById (int id) throws  SQLException;
    List<RentOrder> readAll() throws SQLException;
}
