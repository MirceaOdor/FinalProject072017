package ModelLayer;

/**
 * Created by AsusF550 on 29-Mar-17.
 */
public class Equipment extends Product {
    private String Type;
    private String Descriptiopn;
    private String Barcode;

    public Equipment(String name, String bacrode, String type, int salePrice, int rentPrice, String country, int minStock, int stock, String type1, String descriptiopn, String barcode) {
        super(name, bacrode, type, salePrice, rentPrice, country, minStock, stock);
        Type = type1;
        Descriptiopn = descriptiopn;
        Barcode = barcode;
    }

    public String getEquipmentType() {
        return Type;
    }

    public void setEquipmnetType(String type) {
        Type = type;
    }

    public String getDescriptiopn() {
        return Descriptiopn;
    }

    public void setDescriptiopn(String descriptiopn) {
        Descriptiopn = descriptiopn;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }
}
