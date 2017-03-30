package DBLayer;

import ModelLayer.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.util.Spliterator;

/**
 * Created by Admin on 3/29/2017.
 */
public class SupplierDB implements SupplierDBIF {
    private static SupplierDB instance;

    //singleton
    public static SupplierDB getInstance() {
        if (instance == null) {
            instance = new SupplierDB();
        }
        return instance;
    }

    @Override
    public Supplier create(String ID, String name, String CVR) throws SQLException {
        Supplier s = new Supplier(ID, name, CVR);

        String sql = String.format("INSERT INTO Supplier (ID, name, CVR) VALUES "
                + "('%s', '%s', '%s')", ID, name, CVR);
        try (Connection conn = DBConnection.getInstance().getDBcon();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return s;
    }

    @Override
    public Supplier update(int id, String object, int index) throws SQLException {
        Supplier s = new Supplier(); // it might bug the code ask and fix this
        String sql;
        switch (index) {
            case 1:
                sql = String.format("UPDATE Supplier SET ID = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 2:
                sql = String.format("UPDATE Supplier SET name = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 3:
                sql = String.format("UPDATE Supplier SET CVR = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            default:
                break;
        }

        return s;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean ok = true;
        String sql = String.format("DELETE FROM Supplier WHERE id = '%d'", id);
        try (
                Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
            stmt.executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return ok;
    }

    @Override
    public Supplier readById(int id) throws SQLException {
        Supplier s = null;

        String sql = "SELECT ID,Name,cvr FROM Supplier WHERE ID = " + id;

        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                s = buildObject(rs);// create method buildObject
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return s;
    }

    @Override
    public ArrayList<Supplier> readAll() throws SQLException {
        ArrayList<Supplier> s = new ArrayList<>();
        String sql = "SELECT * FROM Supplier";
        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                s = buildObjects(rs);// create method buildObject
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        for (Supplier supp:s) {
            System.out.println(supp);
        }


        return s;
    }

    private Supplier buildObject(ResultSet rs) throws SQLException{
        Supplier s = new Supplier();
        try {
            s.setID(rs.getString("ID"));
            s.setName(rs.getString("name"));
            s.setCVR(rs.getString("CVR"));
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return s;
    }

    private ArrayList<Supplier> buildObjects(ResultSet rs) throws SQLException{
        ArrayList<Supplier> cs = new ArrayList<>();
        while(rs.next()) {
            cs.add(buildObject(rs));
        }
        return cs;
    }

}
