package ModelLayer;

import java.util.Date;

/**
 * Created by AsusF550 on 29-Mar-17.
 */
public class SaleInvoice {
    private String Id;
    private double Sum;
    private String OrderID;
    private Date Pay_Day;

    public SaleInvoice(){

    }

    public SaleInvoice(String id, double sum, String orderID, Date pay_Day) {
        Id = id;
        Sum = sum;
        OrderID = orderID;
        Pay_Day = new Date();
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public double getSum() {
        return Sum;
    }

    public void setSum(double sum) {
        Sum = sum;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public Date getPay_Day() {
        return Pay_Day;
    }

    public void setPay_Day(Date pay_Day) {
        Pay_Day = pay_Day;
    }
}

