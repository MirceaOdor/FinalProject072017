package DBLayer;

import java.sql.SQLException;
import java.util.*;
import java.sql.*;

/**
 * Created by Admin on 3/29/2017.
 */
public class RentInvoiceDB implements RentInvoiceDBIF {
    private static RentInvoiceDB instance;

    //singleton
    public static RentInvoiceDB getInstance() {
        if (instance == null) {
            instance = new RentInvoiceDB();
        }
        return instance;
    }

    @Override
    public RentInvoice create(String id, double sum, String rentOrderID, java.util.Date pay_day, int period) throws SQLException {
        RentInvoice s = new RentInvoice( id, sum, rentOrderID, pay_day,period);

        String sql = String.format("INSERT INTO RentInvoice ( id, sum, rentOrderID, pay_day,period) VALUES "
                + "('%s', '%s', '%s', '%s', '%s')", id, sum, rentOrderID, pay_day,period);
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
    public RentInvoice update(int id, String object, int index) throws SQLException {
        RentInvoice s = new RentInvoice(); // it might bug the code ask and fix this
        String sql;
        switch (index) {
            case 1:
                sql = String.format("UPDATE RentInvoice SET id = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 2:
                sql = String.format("UPDATE RentInvoice SET sum = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 3:
                sql = String.format("UPDATE RentInvoice SET RentOrder = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            case 4:
                sql = String.format("UPDATE RentInvoice SET Pay_day = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            case 5:
                sql = String.format("UPDATE RentInvoice SET Period = '%s' WHERE id = '%d'", object, id);
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
        String sql = String.format("DELETE FROM RentInvoice WHERE id = '%d'", id);
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
    public RentInvoice readById(int id) throws SQLException {
        RentInvoice s = null;

        String sql = "SELECT String id, double sum, String rentOrderID, java.util.Date pay_day, int period WHERE ID = " + id;

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
    public ArrayList<RentInvoice> readAll() throws SQLException {
        ArrayList<RentInvoice> s = new ArrayList<>();
        String sql = "SELECT * FROM RentInvoice";
        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                s = buildObjects(rs);// create method buildObject
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        for (RentInvoice supp:s) {
            System.out.println(supp);
        }


        return s;
    }

    private RentInvoice buildObject(ResultSet rs) throws SQLException{
        RentInvoice s = new RentInvoice();
        try {
            s.setId(rs.getString("name"));
            s.setSum(rs.getDouble("Sum"));
            s.setRentOrderID(rs.getString("RentOrderId"));
            s.setPay_day(rs.getDate("pay_day"));
            s.setPeriod(rs.getInt("RentPeriod"));
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return s;
    }

    private ArrayList<RentInvoice> buildObjects(ResultSet rs) throws SQLException{
        ArrayList<RentInvoice> cs = new ArrayList<>();
        while(rs.next()) {
            cs.add(buildObject(rs));
        }
        return cs;
    }

}
