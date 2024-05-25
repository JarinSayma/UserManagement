package ClothingStore;


import java.util.List;

public interface UserManager {
    void registerUser(User user);
    User loginUser(String username, String password);
    void updateUserProfile(User user);
    List<Item> searchItems(String keyword);
    void addToWishlist(User user, Item item);
    void removeFromWishlist(User user, Item item);
    void provideFeedback(User user, String feedback);
    Order placeOrder(User user, List<Item> items);
    void makePayment(Order order, Payment payment);
    void addShippingInfo(Order order, ShippingInfo shippingInfo);
}
