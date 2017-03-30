package DBLayer;
import ModelLayer.*;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Alexander on 3/30/2017.
 */

public class DBPerson implements IFDBPer {
    private Connection con;

    /**
     * Creates a new instance of DBEmployee
     */
    public DBEmployee() {
        con = DBConnection.getInstance().getDBcon();
    }

    //Implements the methods from the interface
    // get all employees
    public ArrayList<Person> getAllEmployees(boolean seeAssociation) {
        return miscWhere("", retriveAssociation);
    }

    //get one employee having the ssn
    public Employee findEmployee(String empssn, boolean retriveAssociation) {
        String wClause = "  ssn = '" + empssn + "'";
        return singleWhere(wClause, retriveAssociation);
    }

    //find one employee having the fname
    public Employee searchEmployeeFname(String attValue, boolean retriveAssociation) {
        String wClause = "fname like '%" + attValue + "%'";
        System.out.println("SearchEmployye " + wClause);
        return singleWhere(wClause, retriveAssociation);
    }

    //find one employee having the lname
    public Employee searchEmployeeLname(String attValue, boolean retriveAssociation) {
        String wClause = "lname = '" + attValue + "'";
        System.out.println("SearchEmployye " + wClause);
        return singleWhere(wClause, retriveAssociation);
    }

    //insert a new employee
    @Override
    public int insertEmployee(Employee emp) throws Exception {  //call to get the next ssn number
        int nextSSN = GetMax.getMaxId("Select max(ssn) from employee");
        nextSSN = nextSSN + 1;
        System.out.println("next ssn = " + nextSSN);

        int rc = -1;
        String query = "INSERT INTO employee(fname, lname, ssn,super_ssn,dno)  VALUES('" +
                emp.getFname() + "','" +
                emp.getLname() + "','" +
                nextSSN + "','" +
                emp.getSupervisor().getSsn() + "',5)";


        System.out.println("insert : " + query);
        try { // insert new employee +  dependent
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//end try
        catch (SQLException ex) {
            System.out.println("Employee ikke oprettet");
            throw new Exception("Employee is not inserted correct");
        }
        return (rc);
    }

    @Override
    public int updateEmployee(Employee emp) {
        Employee empObj = emp;
        int rc = -1;

        String query = "UPDATE employee SET " +
                "fname ='" + empObj.getFname() + "', " +
                "lname ='" + empObj.getLname() + "', " +
                "salary ='" + empObj.getSalary() + "', " +
                "super_ssn ='" + empObj.getSupervisor().getSsn() + "' " +
                " WHERE ssn = '" + empObj.getSsn() + "'";
        System.out.println("Update query:" + query);
        try { // update employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);

            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Update exception in employee db: " + ex);
        }
        return (rc);
    }

    public int delete(String ssn) {
        int rc = -1;

        String query = "DELETE FROM employee WHERE ssn = '" +
                ssn + "'";
        System.out.println(query);
        try { // delete from employee
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            rc = stmt.executeUpdate(query);
            stmt.close();
        }//slut try
        catch (Exception ex) {
            System.out.println("Delete exception in employee db: " + ex);
        }
        return (rc);
    }

    //private methods
    //miscWere is used whenever we want to select more than one employee


    private ArrayList<Employee> miscWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        ArrayList<Employee> list = new ArrayList<Employee>();

        String query = buildQuery(wClause);

        try { // read the employee from the database
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);


            while (results.next()) {
                Employee empObj = new Employee();
                empObj = buildEmployee(results);
                list.add(empObj);
            }//end while
            stmt.close();
            if (retrieveAssociation) {   //The supervisor and department is to be build as well
                for (Employee empObj : list) {
                    String superssn = empObj.getSupervisor().getSsn();
                    Employee superEmp = singleWhere(" ssn = '" + superssn + "'", false);
                    empObj.setSupervisor(superEmp);
                    System.out.println("Supervisor is seleceted");
                    // here the department has to be selected as well
                }
            }//end if

        }//slut try
        catch (Exception e) {
            System.out.println("Query exception - select: " + e);
            e.printStackTrace();
        }
        return list;
    }

    //Singlewhere is used when we only select one employee
    private Employee singleWhere(String wClause, boolean retrieveAssociation) {
        ResultSet results;
        Employee empObj = new Employee();

        String query = buildQuery(wClause);
        System.out.println(query);
        try { // read the employee from the database
            Statement stmt = con.createStatement();
            stmt.setQueryTimeout(5);
            results = stmt.executeQuery(query);


            if (results.next()) {
                empObj = buildEmployee(results);
                //association is to be build
                if (retrieveAssociation) {   //The supervisor and department is to be build as well
                    String superssn = empObj.getSupervisor().getSsn();
                    Employee superEmp = singleWhere(" ssn = '" + superssn + "'", false);
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
        String query = "SELECT fname, minit,lname,ssn, address, bdate,sex, salary, super_ssn,dno  FROM employee";

        if (wClause.length() > 0)
            query = query + " WHERE " + wClause;

        return query;
    }

    //method to build an employee object
    private Employee buildEmployee(ResultSet results) {
        Employee empObj = new Employee();
        try { // the columns from the table emplayee  are used
            empObj.setFname(results.getString("fname"));
            empObj.setMinit(results.getString("minit"));
            empObj.setLname(results.getString("lname"));
            empObj.setSsn(results.getString("ssn"));
            empObj.setBdate(results.getString("bdate"));
            empObj.setAddress(results.getString("address"));
            empObj.setSex(results.getString("sex"));
            empObj.setSalary(results.getDouble("salary"));
            empObj.setSupervisor(new Employee(results.getString("super_ssn")));
            empObj.setDepartment(new Department(results.getInt("dno")));
        } catch (Exception e) {
            System.out.println("error in building the employee object");
        }
        return empObj;
    }

    @Override
    public Employee searchEmployeeSsn(String ssn, boolean b) {
        // TODO Auto-generated method stub
        return null;
    }
}