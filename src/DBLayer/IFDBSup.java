package DBLayer;

import ModelLayer.Supplier;

import java.xml.bind.annotation.XmlType;
import java.util.ArrayList;

/**
 * Created by Alexander on 3/30/2017.
 */
public interface IFDBSup {
    // get all products
    public ArrayList<Supplier> getAllSuppliers(boolean retriveAssociation);

    //get one supplier having the id
    public default Supplier(String id, boolean seeAssociation){

    }


    //find one supplier having the name
    public Supplier searchSupplierName(String Name, boolean retriveAssociation);

    public Supplier searchSupplierCVR( String CVR, boolean retriveAssociation);

    //update information about a supplier
    public int insertsupplier(Supplier sup)throws Exception;


    }


