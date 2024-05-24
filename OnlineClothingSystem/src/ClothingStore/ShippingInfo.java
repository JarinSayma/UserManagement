package ClothingStore;

public class ShippingInfo {
    private String address;
    private String contactDetails;

    public ShippingInfo(String address, String contactDetails) {
        this.address = address;
        this.contactDetails = contactDetails;
    }

    public String getAddress() {
        return address;
    }

    public String getContactDetails() {
        return contactDetails;
    }
}
