package DBLayer;

import ModelLayer.SaleInvoice;

import java.sql.SQLException;
import java.util.*;
import java.sql.*;
import java.util.Date;

/**
 * Created by Admin on 3/29/2017.
 */
public class SaleInvoiceDB implements SaleInvoiceDBIF {
    private static SaleInvoiceDB instance;

    //singleton
    public static SaleInvoiceDB getInstance() {
        if (instance == null) {
            instance = new SaleInvoiceDB();
        }
        return instance;
    }

    @Override
    public SaleInvoice create(String id, double sum, String orderID, java.util.Date pay_Day) throws SQLException {
        SaleInvoice s = new SaleInvoice(id, sum, orderID, pay_Day);

        String sql = String.format("INSERT INTO SaleInvoice (id, sum, orderID, pay_Day) VALUES "
                + "('%s', '%s', '%s', '%s')", id, sum, orderID, pay_Day);
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
    public SaleInvoice update(int id, String object, int index) throws SQLException {
        SaleInvoice s = new SaleInvoice(); // it might bug the code ask and fix this
        String sql;
        switch (index) {
            case 1:
                sql = String.format("UPDATE SaleInvoice SET id = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 2:
                sql = String.format("UPDATE SaleInvoice SET sum = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 3:
                sql = String.format("UPDATE SaleInvoice SET OrderID = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            case 4:
                sql = String.format("UPDATE SaleInvoice SET Pay_day = '%s' WHERE id = '%d'", object, id);
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
        String sql = String.format("DELETE FROM SaleInvoice WHERE id = '%d'", id);
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
    public SaleInvoice readById(int id) throws SQLException {
        SaleInvoice s = null;

        String sql = "SELECT String id, double sum, String orderID, java.util.Date pay_Day WHERE ID = " + id;

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
    public ArrayList<SaleInvoice> readAll() throws SQLException {
        ArrayList<SaleInvoice> s = new ArrayList<>();
        String sql = "SELECT * FROM SaleInvoice";
        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                s = buildObjects(rs);// create method buildObject
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        for (SaleInvoice supp:s) {
            System.out.println(supp);
        }


        return s;
    }

    private SaleInvoice buildObject(ResultSet rs) throws SQLException{
        SaleInvoice s = new SaleInvoice();
        try {
            s.setId(rs.getString("id"));
            s.setSum(rs.getDouble("sum"));
            s.setOrderID(rs.getString("OrderId"));
            s.setPay_Day(rs.getDate("pay_day"));
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return s;
    }

    private ArrayList<SaleInvoice> buildObjects(ResultSet rs) throws SQLException{
        ArrayList<SaleInvoice> cs = new ArrayList<>();
        while(rs.next()) {
            cs.add(buildObject(rs));
        }
        return cs;
    }

}
