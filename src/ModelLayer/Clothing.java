package ModelLayer;

/**
 * Created by AsusF550 on 29-Mar-17.
 */
public class Clothing extends Product {
    private String Category;
    private String Size;
    private String Color;
    private String Barcode;

    public Clothing(String name, String bacrode, String type, int salePrice, int rentPrice, String country, int minStock, int stock, String category, String size, String color, String barcode) {
        super(name, bacrode, type, salePrice, rentPrice, country, minStock, stock);
        Category = category;
        Size = size;
        Color = color;
        Barcode = barcode;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }
}
