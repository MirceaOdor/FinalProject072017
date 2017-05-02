package DBLayer;

import java.sql.SQLException;
import java.util.*;
import java.sql.*;

/**
 * Created by Admin on 3/29/2017.
 */
public class RentOrderDB implements RentOrderDBIF {
    private static RentOrderDB instance;

    //singleton
    public static RentOrderDB getInstance() {
        if (instance == null) {
            instance = new RentOrderDB();
        }
        return instance;
    }

    @Override
    public RentOrder create(String id, String barcode, int quantity, java.util.Date start_Day, int duration, String personalID) throws SQLException {
        RentOrder s = new RentOrder( id, barcode, quantity, start_Day, duration, personalID);

        String sql = String.format("INSERT INTO RentOrder ( id, barcode, quantity, start_Day, duration, personalID) VALUES "
                + "('%s', '%s', '%s', '%s', '%s','%s')", id, barcode, quantity, start_Day, duration, personalID);
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
    public RentOrder update(int id, String object, int index) throws SQLException {
        RentOrder s = new RentOrder(); // it might bug the code ask and fix this
        String sql;
        switch (index) {
            case 1:
                sql = String.format("UPDATE RentOrder SET id = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 2:
                sql = String.format("UPDATE RentOrder SET barcode = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 3:
                sql = String.format("UPDATE RentOrder SET Quantity = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            case 4:
                sql = String.format("UPDATE RentOrder SET start_day = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            case 5:
                sql = String.format("UPDATE RentOrder SET duration = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            case 6:
                sql = String.format("UPDATE RentOrder SET PersonalID = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            default:
                break;
        }

        return s;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean ok = true;
        String sql = String.format("DELETE FROM RentOrder WHERE id = '%d'", id);
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
    public RentOrder readById(int id) throws SQLException {
        RentOrder s = null;

        String sql = "SELECT id, barcode, quantity, start_Day, duration, personalID WHERE ID = " + id;

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
    public ArrayList<RentOrder> readAll() throws SQLException {
        ArrayList<RentOrder> s = new ArrayList<>();
        String sql = "SELECT * FROM RentOrder";
        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                s = buildObjects(rs);// create method buildObject
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        for (RentOrder supp:s) {
            System.out.println(supp);
        }


        return s;
    }

    private RentOrder buildObject(ResultSet rs) throws SQLException{
        RentOrder s = new RentOrder();
        try {
            s.setId(rs.getString("id"));
            s.setBarcode(rs.getString("barcode"));
            s.setQuantity(rs.getInt("Quantity"));
            s.setStart_Day(rs.getDate("start_day"));
            s.setDuration(rs.getInt("duration"));
            s.setPersonalID(rs.getString("personalId"));
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return s;
    }

    private ArrayList<RentOrder> buildObjects(ResultSet rs) throws SQLException{
        ArrayList<RentOrder> cs = new ArrayList<>();
        while(rs.next()) {
            cs.add(buildObject(rs));
        }
        return cs;
    }

}
