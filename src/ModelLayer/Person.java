package ModelLayer;

/**
 * Created by Vlad Mataoanu on 29.03.2017.
 */
public class Person {
    private String id;
    private String f_name;
    private String l_name;
    private int CPR;
    private String address;
    private String phNr;
    private String city;
    private int zip;
    private String function;

    /*
      public Person(String id, int CPR, String function) {
      this.id = id;
      this.CPR = CPR;
      this.function = function;
      */


    public Person(String id, String f_name, String l_name, int CPR, String address, String phNr, String city, int zip, String function) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.CPR = CPR;
        this.address = address;
        this.phNr = phNr;
        this.city = city;
        this.zip = zip;
        this.function = function;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public int getCPR() {
        return CPR;
    }

    public void setCPR(int CPR) {
        this.CPR = CPR;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhNr() {
        return phNr;
    }

    public void setPhNr(String phNr) {
        this.phNr = phNr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
