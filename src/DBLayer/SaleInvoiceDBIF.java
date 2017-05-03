package DBLayer;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  SaleInvoiceDBIF {

    SaleInvoice create (String id, double sum, String orderID, Date pay_Day) throws SQLException;
    SaleInvoice update (int id, String object, int index) throws SQLException;
    boolean delete (int id) throws SQLException;
    SaleInvoice readById (int id) throws  SQLException;
    List<SaleInvoice> readAll() throws SQLException;
}
