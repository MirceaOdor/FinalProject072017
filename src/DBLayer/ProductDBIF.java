package DBLayer;

import ModelLayer.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  ProductDBIF {

    boolean create (String name, String barcode, int productionTime, double price, int stock) throws SQLException;
    boolean update (Product product) throws SQLException;
    boolean delete (String barcode) throws SQLException;
    Product read (String barcode) throws SQLException;
    Product buildObject(ResultSet rs) throws SQLException;
}
