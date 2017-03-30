package DBLayer;

import ModelLayer.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  ProductDBIF {

    Product create (String name, String barcode, String type, int salePrice, int rentPrice, String country, int minStock, int stock) throws SQLException;
    Product update (int id, String object, int index) throws SQLException;
    boolean delete (int id) throws SQLException;
    Product readById (int id) throws  SQLException;
    List<Product> readAll() throws SQLException;
}
