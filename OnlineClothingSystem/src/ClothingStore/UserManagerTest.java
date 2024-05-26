package ClothingStore;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import ClothingStore.User;
import ClothingStore.UserManager;
import ClothingStore.UserManagerImpl;
import ClothingStore.Item;
import ClothingStore.Order;

public class UserManagerTest {

    private UserManager userManager;
    private User testUser;
    private Item testItem;

    @Before
    public void setUp() {
        userManager = UserManagerImpl.getInstance();
        testUser = new User("JArin", "jane@example.com", "password456");
        testItem = new Item("T-shirt", 20.00);
    }

    @Test
    public void testRegisterUser() {
        // Mock input values
        String name = "JArin";
        String email = "jane@example.com";
        String password = "password123";
        
        // Call registerUser with mock input values
        User user = userManager.registerUser(name, email, password);
        
        // Assertions
        assertNotNull(user);
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
    }

    @Test
    public void testLoginUser() {
        // Mock input values
        String email = "jane@example.com";
        String password = "password456";
        
        // Call loginUser with mock input values
        User loggedInUser = userManager.loginUser(email, password);
        
        // Assertions
        assertNotNull(loggedInUser);
        assertEquals("JArin", loggedInUser.getName());
    }

    @Test
    public void testUpdateUserProfile() {
        // Mock input value
        String address = "470 burrk3";
        
        // Set address for testUser
        testUser.setAddress(address);
        
        // Assertion
        assertEquals(address, testUser.getAddress());
    }

    @Test
    public void testAddToWishlist() {
        // Mock item
        Item mockItem = new Item("scarf", 15.99);
        
        // Add mockItem to wishlist
        testUser.addToWishlist(mockItem);
        
        // Assertion
        assertTrue(testUser.getWishlist().contains(mockItem));
    }

    @Test
    public void testPlaceOrder() {
        // Mock item
        Item mockItem = new Item("scarf", 15.99);
        
        // Add mockItem to user's wishlist
        testUser.addToWishlist(mockItem);
        
        // Place order for testUser
        Order order = testUser.placeOrder();
        
        // Assertions
        assertNotNull(order);
        assertEquals(1, order.getItems().size());
        assertEquals(mockItem, order.getItems().get(0));
    }
}
