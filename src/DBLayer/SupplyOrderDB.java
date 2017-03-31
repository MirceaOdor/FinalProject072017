package DBLayer;

import ModelLayer.SupplyOrder;

import java.sql.SQLException;
import java.util.*;
import java.sql.*;

/**
 * Created by Admin on 3/29/2017.
 */
public class SupplyOrderDB implements SupplyOrderDBIF {
    private static SupplyOrderDB instance;

    //singleton
    public static SupplyOrderDB getInstance() {
        if (instance == null) {
            instance = new SupplyOrderDB();
        }
        return instance;
    }

    @Override
    public SupplyOrder create(String id, String prodType, double qty, java.util.Date date, java.util.Date dlvDate, String sID) throws SQLException {
        SupplyOrder s = new SupplyOrder( id, prodType, qty, date, dlvDate,sID);

        String sql = String.format("INSERT INTO SupplyOrder ( id, prodType, qty, date, dlvDate,sID) VALUES "
                + "('%s', '%s', '%s', '%s', '%s','%s')", id, prodType, qty, date, dlvDate,sID);
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
    public SupplyOrder update(int id, String object, int index) throws SQLException {
        SupplyOrder s = new SupplyOrder(); // it might bug the code ask and fix this
        String sql;
        switch (index) {
            case 1:
                sql = String.format("UPDATE SupplyOrder SET id = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 2:
                sql = String.format("UPDATE SupplyOrder SET prodType = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 3:
                sql = String.format("UPDATE SupplyOrder SET Quantity = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            case 4:
                sql = String.format("UPDATE SupplyOrder SET date = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            case 5:
                sql = String.format("UPDATE SupplyOrder SET delivery date = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            case 6:
                sql = String.format("UPDATE SupplyOrder SET sID = '%s' WHERE id = '%d'", object, id);
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
        String sql = String.format("DELETE FROM SupplyOrder WHERE id = '%d'", id);
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
    public SupplyOrder readById(int id) throws SQLException {
        SupplyOrder s = null;

        String sql = "SELECT String id, String prodType, double qty, java.util.Date date, java.util.Date dlvDate, String sID WHERE ID = " + id;

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
    public ArrayList<SupplyOrder> readAll() throws SQLException {
        ArrayList<SupplyOrder> s = new ArrayList<>();
        String sql = "SELECT * FROM SupplyOrder";
        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                s = buildObjects(rs);// create method buildObject
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        for (SupplyOrder supp:s) {
            System.out.println(supp);
        }


        return s;
    }

    private SupplyOrder buildObject(ResultSet rs) throws SQLException{
        SupplyOrder s = new SupplyOrder();
        try {
            s.setId(rs.getString("id"));
            s.setProdType(rs.getString("prodType"));
            s.setQty(rs.getInt("Quantity"));
            s.setDate(rs.getDate("date"));
            s.setDlvDate(rs.getDate("Delivery date"));
            s.setsID(rs.getString("supply ID"));
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return s;
    }

    private ArrayList<SupplyOrder> buildObjects(ResultSet rs) throws SQLException{
        ArrayList<SupplyOrder> cs = new ArrayList<>();
        while(rs.next()) {
            cs.add(buildObject(rs));
        }
        return cs;
    }

}
