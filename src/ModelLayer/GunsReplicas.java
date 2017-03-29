package ModelLayer;

/**
 * Created by AsusF550 on 29-Mar-17.
 */
public class GunsReplicas extends Product {
    private String Calibre;
    private String Material;
    private String Barcode;


    public GunsReplicas(String name, String bacrode, String type, int salePrice, int rentPrice, String country, int minStock, int stock, String calibre, String material, String barcode) {
        super(name, bacrode, type, salePrice, rentPrice, country, minStock, stock);
        Calibre = calibre;
        Material = material;
        Barcode = barcode;
    }

    public String getCalibre() {
        return Calibre;
    }

    public void setCalibre(String calibre) {
        Calibre = calibre;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }
}
