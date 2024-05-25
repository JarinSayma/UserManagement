package ClothingStore;


import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements UserManager {
    private static UserManagerImpl instance;
    private List<User> users = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    private UserManagerImpl() {
        // Initialize with some items
        items.add(new Item("T-shirt", 20));
        items.add(new Item("Jeans", 30));
    }

    public static UserManagerImpl getInstance() {
        if (instance == null) {
            instance = new UserManagerImpl();
        }
        return instance;
    }

    @Override
    public void registerUser(User user) {
        users.add(user);
    }

    @Override
    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void updateUserProfile(User user) {
        // In a real application, this would update the user's profile in a database
    }

    @Override
    public List<Item> searchItems(String keyword) {
        List<Item> results = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    @Override
    public void addToWishlist(User user, Item item) {
        // In a real application, this would add the item to the user's wishlist in a database
    }

    @Override
    public void removeFromWishlist(User user, Item item) {
        // In a real application, this would remove the item from the user's wishlist in a database
    }

    @Override
    public void provideFeedback(User user, String feedback) {
        // In a real application, this would store the feedback in a database
    }

    @Override
    public Order placeOrder(User user, List<Item> items) {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return new Order(items, totalPrice);
    }

    @Override
    public void makePayment(Order order, Payment payment) {
        // In a real application, this would process the payment
    }

    @Override
    public void addShippingInfo(Order order, ShippingInfo shippingInfo) {
        // In a real application, this would add the shipping info to the order
    }
}
