package ModelLayer;

/**
 * Created by Mircea on 27-Mar-17.
 */
public class Product {

    private String name;
    private String barcode;
    private String type;
    private double price;
    private int stock;
    /**REQ RAW*/

    public Product(){

    }

    public Product(String name, String barcode, String type, double price, int stock) {
        this.name = name;
        this.barcode = barcode;
        this.type = type;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
