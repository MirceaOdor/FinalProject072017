package DBLayer;

import ModelLayer.*;

import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

/**
 * Created by Alexander on 3/30/2017.
 */


    public interface IFDBPer {
        // get all people
        public ArrayList<Person> getAllpeople(boolean seeAssociation);

        //get one employee having the id
        public default Person(String id, boolean seeAssociation) {

        }

        //find one people having the name
        public Person searchEmployeeFname(String f_name, boolean seeAssociation);

        public Person searchEmployeeLname(String l_name, boolean seeAssociation);

        //insert a new person
        public int insertpeople(Person per) throws Exception;

        //update information about an people
        public int updatepeople(Person per);

        public Person searchPeopleId(String id, boolean b);
    }
}
