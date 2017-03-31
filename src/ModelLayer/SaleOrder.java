package ModelLayer;

import java.util.Date;

/**
 * Created by Vlad Mataoanu on 29.03.2017.
 */
public class SaleOrder {
    private String OID;
    private String barcode;
    private int quantity;
    private String delivery_status;
    private Date saleDate;
    private Date deliveryDate;
    private double sale_promotion;
    private String persId;

    public SaleOrder(String OID, String barcode, int quantity, String delivery_status, Date saleDate, Date deliveryDate, double sale_promotion, String persId) {
        this.OID = OID;
        this.barcode = barcode;
        this.quantity = quantity;
        this.delivery_status = delivery_status;
        saleDate =new Date();
        deliveryDate =new Date();
        this.sale_promotion = sale_promotion;
        this.persId = persId;
    }

    public String getOID() {
        return OID;
    }

    public void setID(String ID) {
        this.OID = OID;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(String delivery_status) {
        this.delivery_status = delivery_status;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(int date,int month,int year) {
        saleDate.setDate(date);
        saleDate.setMonth(month);
        saleDate.setYear(year);
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(int date,int month,int year) {
        deliveryDate.setDate(date);
        deliveryDate.setMonth(month);
        deliveryDate.setYear(year);
    }

    public double getSale_promotion() {
        return sale_promotion;
    }

    public void setSale_promotion(double sale_promotion) {
        this.sale_promotion = sale_promotion;
    }

    public String getPersId() {
        return persId;
    }

    public void setPersId(String persId) {
        this.persId = persId;
    }
}
