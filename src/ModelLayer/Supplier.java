package ModelLayer;

/**
 * Created by AsusF550 on 29-Mar-17.
 */
public class Supplier {
    private String ID;
    private String Name;
    private String CVR;

    public Supplier(String ID, String name, String CVR) {
        this.ID = ID;
        Name = name;
        this.CVR = CVR;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCVR() {
        return CVR;
    }

    public void setCVR(String CVR) {
        this.CVR = CVR;
    }
}
