package ModelLayer;

import java.util.Date;

/**
 * Created by Vlad Mataoanu on 02.05.2017.
 */
public class Order {
    private String id;
    private Date deliveryDate;
    private String orderStatus;
    private double price;

    public Order(String id, Date deliveryDate, String orderStatus, double price) {
        this.id = id;
        this.deliveryDate = deliveryDate;
        this.orderStatus = orderStatus;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
