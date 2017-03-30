package DBLayer;

import ModelLayer.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

/**
 * Created by Admin on 3/29/2017.
 */
public class ProductDB implements ProductDBIF {
    private static ProductDB instance;

    //singleton
    public static ProductDB getInstance() {
        if (instance == null) {
            instance = new ProductDB();
        }
        return instance;
    }

    @Override
    public Product create(String name, String barcode, String type, int salePrice, int rentPrice, String country, int minStock, int stock) throws SQLException {
        Product s = new Product(name,barcode, type, salePrice, rentPrice, country, minStock,stock);

        String sql = String.format("INSERT INTO Product (name,barcode, type, salePrice, rentPrice, country, minStock,stock) VALUES "
                + "('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", name,barcode, type, salePrice, rentPrice, country, minStock,stock);
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
    public Product update(int id, String object, int index) throws SQLException {
        Product s = new Product(); // it might bug the code ask and fix this
        String sql;
        switch (index) {
            case 1:
                sql = String.format("UPDATE Product SET name = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 2:
                sql = String.format("UPDATE Product SET barcode = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
                break;
            case 3:
                sql = String.format("UPDATE Product SET Type = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            case 4:
                sql = String.format("UPDATE Product SET SalePrice = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            case 5:
                sql = String.format("UPDATE Product SET RentPrice = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            case 6:
                sql = String.format("UPDATE Product SET Country = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            case 7:
                sql = String.format("UPDATE Product SET minStock = '%s' WHERE id = '%d'", object, id);
                try (
                        Statement stmt = DBConnection.getInstance().getDBcon().createStatement()) {
                    stmt.executeUpdate(sql);
                } catch(SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            case 8:
                sql = String.format("UPDATE Product SET stock = '%s' WHERE id = '%d'", object, id);
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
        String sql = String.format("DELETE FROM Product WHERE id = '%d'", id);
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
    public Product readById(int id) throws SQLException {
        Product s = null;

        String sql = "SELECT String name, String barcode, String type, int salePrice, int rentPrice, String country, int minStock, int stock WHERE ID = " + id;

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
    public ArrayList<Product> readAll() throws SQLException {
        ArrayList<Product> s = new ArrayList<>();
        String sql = "SELECT * FROM Product";
        try(Statement st = DBConnection.getInstance().getDBcon().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                s = buildObjects(rs);// create method buildObject
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
        for (Product supp:s) {
            System.out.println(supp);
        }


        return s;
    }

    private Product buildObject(ResultSet rs) throws SQLException{
        Product s = new Product();
        try {
            s.setName(rs.getString("name"));
            s.setBarcode(rs.getString("barcode"));
            s.setType(rs.getString("Type"));
            s.setSalePrice(rs.getInt("SalePrice"));
            s.setRentPrice(rs.getInt("RentPrice"));
            s.setCountry(rs.getString("Country"));
            s.setMinStock(rs.getInt("minStock"));
            s.setStock(rs.getInt("stock"));
        } catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return s;
    }

    private ArrayList<Product> buildObjects(ResultSet rs) throws SQLException{
        ArrayList<Product> cs = new ArrayList<>();
        while(rs.next()) {
            cs.add(buildObject(rs));
        }
        return cs;
    }

}
