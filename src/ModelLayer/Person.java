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

    public Person(String id, int CPR, String function) {
        this.id = id;
        this.CPR = CPR;
        this.function = function;
    }

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
}
