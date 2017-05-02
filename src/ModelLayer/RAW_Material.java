package ModelLayer;

/**
 * Created by Vlad Mataoanu on 02.05.2017.
 */
public class RAW_Material {
    private String barcode;
    private int stock;
    private int minStock;
    private String name;

    public RAW_Material(String barcode, int stock, int minStock, String name) {
        this.barcode = barcode;
        this.stock = stock;
        this.minStock = minStock;
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
