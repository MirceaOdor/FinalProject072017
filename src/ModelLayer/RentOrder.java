package ModelLayer;

/**
 * Created by AsusF550 on 29-Mar-17.
 */

import java.util.Date;


public class RentOrder {
    private String Id;
    private String Barcode;
    private int quantity;
    private Date Start_Day;
    private int Duration;
    private String PersonalID;


    public RentOrder(){

    }

    public RentOrder(String id, String barcode, int quantity, Date start_Day, int duration, String personalID) {
        Id = id;
        Barcode = barcode;
        this.quantity = quantity;
        Start_Day =new Date();
        Duration = duration;
        PersonalID = personalID;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getStart_Day() {
        return Start_Day;
    }

    public void setStart_Day(Date start_Day) {
        Start_Day = start_Day;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public String getPersonalID() {
        return PersonalID;
    }

    public void setPersonalID(String personalID) {
        PersonalID = personalID;
    }
}
