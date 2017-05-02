package ModelLayer;

/**
 * Created by Vlad Mataoanu on 02.05.2017.
 */
public class Company {
    private String id;
    private String name;
    private String phNr;
    private String email;
    private String type;
    private String address;

    public Company(String id, String name, String phNr, String email, String type, String address) {
        this.id = id;
        this.name = name;
        this.phNr = phNr;
        this.email = email;
        this.type = type;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhNr() {
        return phNr;
    }

    public void setPhNr(String phNr) {
        this.phNr = phNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
