package DBLayer;

import ModelLayer.Person;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alexander on 3/31/2017.
 */
public interface PersonDBIF {

    Person create (String id, String f_name, String l_name, int CPR, String address, String phNr, String city, int zip, String function)throws SQLException;
    Person update (String id, String f_name, String l_name, int CPR, String address, String phNr, String city, int zip, String function,int index,String object) throws SQLException;
    boolean delete (int id) throws SQLException;
    Person readById (int id) throws SQLException;
    List<Person>readAll() throws SQLException;
}
