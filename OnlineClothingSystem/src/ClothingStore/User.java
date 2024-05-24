package ClothingStore;

public class User {
    private String username;
    private String password;
    private String name;
    private String address;
    private String contactDetails;

    public User(String username, String password, String name, String address, String contactDetails) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.contactDetails = contactDetails;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
