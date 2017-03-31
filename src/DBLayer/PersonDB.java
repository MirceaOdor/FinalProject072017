package DBLayer;


import ModelLayer.Person;
import ModelLayer.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
/**
 * Created by Alexander on 3/30/2017.
 */
public class PersonDB implements PersonDBIF {
    private static PersonDB instance;

    //singleton
    public static PersonDB getInstance() {
        if(instance == null) {
            instance = new PersonDB();
        }
        return instance;
    }

    @Override
    public Person create(String id, String f_name, String l_name, int CPR, String address, String phNr, String city, int zip, String function) throws SQLException {
        Person p = new Person(id, f_name, l_name, CPR, address, phNr, city, zip, function);

        String sql = String.format("Insert into Person (id,f_name,l_name,CPR,address,phNr,city,zip,function) VALUES"
                +  "('%s', '%s', '%s' )", id,f_name,l_name,CPR,address,phNr,city,zip,function);

    try(Connection conn = DBConnection.getInstance().getDBcon();
    Statement stmt = conn.createStatement() ) {
        stmt.executeUpdate(sql);
    }
    catch(SQLException e) {
        e.printStackTrace();
        throw e;
    }

    return p;
}
    @Override
    public Person update(String id, String f_name, String l_name, int CPR, String address, String phNr, String city, int zip, String function,int index,String object) throws SQLException {
    Person p = new Person(id, f_name, l_name, CPR, address, phNr, city, zip, function); //asking for constructor :')
    String sql;
    switch (index){
        case 1:
            sql = String.format("Update person Set f_name = '%s' WHERE id = '%d' ",id,object);
            try(
                    Statement stmt = DBConnection.getInstance().getDBcon().createStatement() )
            {
                stmt.executeUpdate(sql);
            }
            catch(SQLException e) {
                e.printStackTrace();
                throw e;
            }
            break;
        case 2:
            sql = String.format("Update person Set l_name = '%s' WHERE id = '%d' ",id,object);
            try(
                    Statement stmt = DBConnection.getInstance().getDBcon().createStatement() )
            {
                stmt.executeUpdate(sql);
            }
            catch(SQLException e) {
                e.printStackTrace();
                throw e;
            }
            break;
        case 3:
            sql = String.format("Update person Set CPR = '%s' WHERE id = '%d' ",id,object);
            try(
                    Statement stmt = DBConnection.getInstance().getDBcon().createStatement() )
            {
                stmt.executeUpdate(sql);
            }
            catch(SQLException e) {
                e.printStackTrace();
                throw e;
            }
            break;
        case 4:
            sql = String.format("Update person Set address = '%s' WHERE id = '%d' ",id,object);
            try(
                    Statement stmt = DBConnection.getInstance().getDBcon().createStatement() )
            {
                stmt.executeUpdate(sql);
            }
            catch(SQLException e) {
                e.printStackTrace();
                throw e;
            }
            break;
        case 5:
            sql = String.format("Update person Set phNr = '%s' WHERE id = '%d' ",id,object);
            try(
                    Statement stmt = DBConnection.getInstance().getDBcon().createStatement() )
            {
                stmt.executeUpdate(sql);
            }
            catch(SQLException e) {
                e.printStackTrace();
                throw e;
            }
            break;
        case 6:
            sql = String.format("Update person Set city= '%s' WHERE id = '%d' ",id,object);
            try(
                    Statement stmt = DBConnection.getInstance().getDBcon().createStatement() )
            {
                stmt.executeUpdate(sql);
            }
            catch(SQLException e) {
                e.printStackTrace();
                throw e;
            }
            break;
        case 7:
            sql = String.format("Update person Set zip = '%s' WHERE id = '%d' ",id,object);
            try(
                    Statement stmt = DBConnection.getInstance().getDBcon().createStatement() )
            {
                stmt.executeUpdate(sql);
            }
            catch(SQLException e) {
                e.printStackTrace();
                throw e;
            }
            break;
        case 8:
            sql = String.format("Update person Set function = '%s' WHERE id = '%d' ",id,object);
            try(
                    Statement stmt = DBConnection.getInstance().getDBcon().createStatement() )
            {
                stmt.executeUpdate(sql);
            }
            catch(SQLException e) {
                e.printStackTrace();
                throw e;
            }
            break;
        default:
            break;

    }
    return p;
    }

    @Override
    public boolean delete(int id ) throws SQLException {
        boolean adev = true;
        String sql = String.format("DELETE FROM Person WHERE id = '%d'", id);
        try(
                Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
            stmt.executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return adev;

    }

    @Override
    public Person readById(int id) throws SQLException {
        Person p = null;
        String sql = "SELECT String f_name, String l_name, int CPR, String address, String phNr, String city, int zip, String function WHERE id = " +id;
        try(
                Statement stmt =DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                ArrayList<Person> people = buildObjects(rs);
                p=people.get(0);
            }
        }

        catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return p;
    }


        @Override
    public ArrayList<Person> readAll() throws SQLException {
            ArrayList<Person> p = new ArrayList<>();
            String sql = "SELECT * FROM Person";
            try (
                    Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    p = buildObjects(rs);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
            for (Person supp : p) {
                System.out.println(supp);
            }
            return p;
    }

    private Person buildObject(ResultSet rs) throws SQLException {
        Person p =new Person();// constructor problem...
        try {
            p.setAddress(rs.getString("address"));
            p.setCity(rs.getString("city"));
            p.setCPR(rs.getInt("CPR"));
            p.setF_name(rs.getString("f_name"));
            p.setL_name(rs.getString("l_name"));
            p.setZip(rs.getInt("zip"));
            p.setPhNr(rs.getString("phNr"));
            p.setFunction(rs.getString("function"));
        }
        catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return p;

    }

    private ArrayList<Person> buildObjects(ResultSet rs) throws SQLException {
        ArrayList<Person> ps = new ArrayList<>();
        while(rs.next())
        {
            ps.add(buildObject(rs));
        }
        return ps;
    }

}

