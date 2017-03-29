package ModelLayer;

import java.util.Date;

/**
 * Created by AsusF550 on 29-Mar-17.
 */
public class RentInvoice {
    private String Id;
    private double sum;
    private String RentOrderID;
    private Date Pay_day;
    private int Period;

    public RentInvoice(String id, double sum, String rentOrderID, Date pay_day, int period) {
        Id = id;
        this.sum = sum;
        RentOrderID = rentOrderID;
        Pay_day = new Date();
        Period = period;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getRentOrderID() {
        return RentOrderID;
    }

    public void setRentOrderID(String rentOrderID) {
        RentOrderID = rentOrderID;
    }

    public Date getPay_day() {
        return Pay_day;
    }

    public void setPay_day(Date pay_day) {
        Pay_day = pay_day;
    }

    public int getPeriod() {
        return Period;
    }

    public void setPeriod(int period) {
        Period = period;
    }
}
