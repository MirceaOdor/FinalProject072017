package DBLayer;

import ModelLayer.Product;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  SaleOrderDBIF {

    SaleOrder create (String OID, String barcode, int quantity, String delivery_status, Date saleDate, Date deliveryDate, double sale_promotion, String persId throws SQLException;
    SaleOrder update (int OID, String object, int index) throws SQLException;
    boolean delete (int OID) throws SQLException;
    SaleOrder readById (int OID) throws  SQLException;
    List<SaleOrder> readAll() throws SQLException;
}
