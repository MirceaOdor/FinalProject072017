package DBLayer;

import ModelLayer.SupplyOrder;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 3/29/2017.
 */
public interface  SupplyOrderDBIF {

    SupplyOrder create (String id, String prodType, double qty, Date date, Date dlvDate, String sID) throws SQLException;
    SupplyOrder update (int id, String object, int index) throws SQLException;
    boolean delete (int id) throws SQLException;
    SupplyOrder readById (int id) throws  SQLException;
    List<SupplyOrder> readAll() throws SQLException;
}
