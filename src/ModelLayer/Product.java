package ModelLayer;

/**
 * Created by Mircea on 27-Mar-17.
 */
public class Product {

    private String name;
    private String barcode;
    private String type;
    private int salePrice;
    private int rentPrice;
    private String country;
    private int minStock;
    private int stock;

    public Product(String name, String barcode, int stock) {
        this.name = name;
        this.barcode = barcode;
        this.stock = stock;
    }

    public Product(String name, String barcode, String type, int salePrice, int rentPrice, String country, int minStock, int stock) {
        this.name = name;
        this.barcode = barcode;
        this.type = type;
        this.salePrice = salePrice;
        this.rentPrice = rentPrice;
        this.country = country;
        this.minStock = minStock;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBacrode() {
        return barcode;
    }

    public void setBacrode(String barcode) {
        this.barcode = barcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
