package ModelLayer;

import java.util.*;

/**
 * Created by Mircea on 27-Mar-17.
 */
public class Product {

    private String name;
    private String barcode;
    private double price;
    private int stock;
    private int productionTime;
    private ArrayList<RAW_Material> rawMaterials;

    public Product(){

    }

    public Product(String name, String barcode, int productionTime, double price, int stock) {
        this.name = name;
        this.barcode = barcode;
        this.productionTime = productionTime;
        this.price = price;
        this.stock = stock;
        rawMaterials=new ArrayList<>();
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

    public void addRawMaterial(RAW_Material raw){
        rawMaterials.add(raw);
    }

    public int getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public void addRequiredRawMaterial(RAW_Material raw){
        rawMaterials.add(raw);
    }

    public void deleteRequiredRawMaterials(RAW_Material raw){
        rawMaterials.remove(raw);
    }

    public ArrayList<RAW_Material> getRawMaterials() {
        return rawMaterials;
    }
}
