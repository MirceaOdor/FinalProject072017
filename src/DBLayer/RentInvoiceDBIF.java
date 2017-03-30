package DBLayer;

import ModelLayer.RentInvoice;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  RentInvoiceDBIF {

    RentInvoice create (String id, double sum, String rentOrderID, java.util.Date pay_day, int period) throws SQLException;
    RentInvoice update (int id, String object, int index) throws SQLException;
    boolean delete (int id) throws SQLException;
    RentInvoice readById (int id) throws  SQLException;
    List<RentInvoice> readAll() throws SQLException;
}
