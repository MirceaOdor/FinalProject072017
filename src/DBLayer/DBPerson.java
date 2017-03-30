package DBLayer;
import ModelLayer.*;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Alexander on 3/30/2017.
 */

public abstract class DBPerson implements IFDBPer {
    private Connection con;

    /**
     * Creates a new instance of DBPerson
     */
    public DBPerson() {
        con = DBConnection.getInstance().getDBcon();
    }

    //Implements the methods from the interface
    // get all persons
    public ArrayList<Person> getAllPersons(boolean seeAssociation) {
        return miscWhere("", retriveAssociation);
    }

    //get one employee having the ID
    public Person findPerson(String empID, boolean retriveAssociation) {
        String wClause = "  ID = '" + empID + "'";
        return singleWhere(wClause, retriveAssociation);
    }

    //find one employee having the fname
    public Person searchPersonFname(String attValue, boolean retriveAssociation) {
        String wClause = "fname like '%" + attValue + "%'";
        System.out.println("SearchEmployye " + wClause);
        return singleWhere(wClause, retriveAssociation);
    }

    //find one employee having the lname
    public Person searchPersonLname(String attValue, boolean retriveAssociation) {
        String wClause = "lname = '" + attValue + "'";
        System.out.println("SearchEmployye " + wClause);
        return singleWhere(wClause, retriveAssociation);
    }

    //insert a new employee
    @Override
    public int insertPerson(Person pers) throws Exception {  //call to get the next ID number

        int rc=-1;
        String query = "INSERT INTO Person(first_name, last_name, ID, CPR, address, phoneNumber, City, ZipCode, function_name)  VALUES('" +
                pers.getF_name() + "','" +
                pers.getL_name() + "','" +
                pers.getId() + " ','" +
                pers.getCPR() + " ','"  +
                pers.getAddress() + " ','"  +
                pers.getPhNr() + " ','"  +
                pers.getCity() + " ','"  +
                pers.getZip() + " ',''"  +
                pers.getFunction() ;



        System.out.println("insert : " + query);
        try { // insert new person +  dependent
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (SQLException ex) {
            System.out.println("Person ikke oprettet");
            throw new Exception("Person is not inserted correct");
        }
        return (rc);
    }

    @Override
    public int updatePerson(Person emp) {
        Person empObj = emp;
        int rc = -1;

        String query = "UPDATE employee SET " +
                "first_name ='" + empObj.getF_name() + "', " +
                "last_name ='" + empObj.getL_name() + "', "  +
                "cpr ='" + empObj.getCPR() + "', "  +
                "address ='" + empObj.getAddress() + "', "  +
                "PhoneNumber ='" + empObj.getPhNr() + "', "  +
                "city ='" + empObj.getCity() + "', "  +
                "Zip Code ='" + empObj.getZip() + "', "  +
                "function ='" + empObj.getFunction() + "', "  +
                " WHERE ID = '" + empObj.getId() + "'";
        System.out.println("Update query:" + query);
        try { // update person
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Update exception in person db: " + ex);
        }
        return (rc);
    }

    public int delete(String ID) {
        int rc = -1;

        String query = "DELETE FROM Person WHERE ID = '" +
                ID + "'";
        System.out.println(query);
        try { // delete from employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Delete exception in person db: " + ex);
        }
        return (rc);
    }

    //private methods


    //Singlewhere is used when we only select one employee
    private Person singleWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        Person empObj = new Person();

        String query = buildQuery(wClause);
        System.out.println(query);
        try { // read the employee from the database
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);


            if (results.next()) {
                empObj = buildPerson(results);
                //association is to be build
                if (retrieveAssociation) {   //The supervisor and department is to be build as well
                    String superID = empObj.getSupervisor().getID();
                    Person superEmp = singleWhere(" ID = '" + superID + "'", false);
                    empObj.setSupervisor(superEmp);
                    System.out.println("Supervisor is seleceted");
                    // here the department has to be selected as well
                }
            } else { //no employee was found
                empObj = null;
            }
            stmt.close();

        }//end try
        catch (Exception e) {
            System.out.println("Query exception: " + e);
        }
        return empObj;
    }

    //method to build the query
    private String buildQuery(String wClause) {
        String query = "SELECT ID, first_name, last_name, CPR, address, phoneNumber,City, ZipCode, function_name, dno  FROM Person";

        if (wClause.length() > 0)
            query = query + " WHERE " + wClause;

        return query;
    }

    //method to build an employee object
    private Person buildPerson(ResultSet results) {
        Person persObj =null;
        try { // the columns from the table perslayee  are used
            persObj.setId(results.getString("ID"));
            persObj.setF_name((results.getString("first_name"));
            persObj.setL_name(results.getString("last_name"));
            persObj.setCPR(results.getInt("CPR"));
            persObj.setZip(results.getInt("ZipCode"));
            persObj.setAddress(results.getString("address"));
            persObj.setFunction(results.getString("function_name"));

        } catch (Exception e) {
            System.out.println("error in building the person object");
        }
        return persObj;
    }

    @Override
    public Person searchPersonID(String ID, boolean b) {
        // TODO Auto-generated method stub
        return null;
    }
}