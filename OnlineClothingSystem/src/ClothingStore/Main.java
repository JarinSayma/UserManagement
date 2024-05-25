package ClothingStore;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = UserManagerImpl.getInstance();
        OrderContext orderContext = new OrderContext();

        System.out.println("Welcome to the Online Clothing Store!");

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Update Profile");
            System.out.println("4. Search Items");
            System.out.println("5. Add to Wishlist");
            System.out.println("6. Remove from Wishlist");
            System.out.println("7. Provide Feedback");
            System.out.println("8. Place Order");
            System.out.println("9. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter contact details: ");
                    String contactDetails = scanner.nextLine();
                    User newUser = new User(username, password, name, address, contactDetails);
                    userManager.registerUser(newUser);
                    System.out.println("User registered: " + username);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    User loggedInUser = userManager.loginUser(username, password);
                    if (loggedInUser != null) {
                        System.out.println("Logged in as: " + loggedInUser.getName());
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 3:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    loggedInUser = userManager.loginUser(username, "");  // Assuming the user is already logged in
                    if (loggedInUser != null) {
                        System.out.print("Enter new address: ");
                        address = scanner.nextLine();
                        loggedInUser.setAddress(address);
                        userManager.updateUserProfile(loggedInUser);
                        System.out.println("Updated address: " + loggedInUser.getAddress());
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter keyword to search items: ");
                    String keyword = scanner.nextLine();
                    List<Item> searchResults = userManager.searchItems(keyword);
                    for (Item item : searchResults) {
                        System.out.println("Found item: " + item.getName() + " - Price: $" + item.getPrice());
                    }
                    break;
                case 5:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    loggedInUser = userManager.loginUser(username, "");  // Assuming the user is already logged in
                    if (loggedInUser != null) {
                        System.out.print("Enter item name to add to wishlist: ");
                        String itemNameToAdd = scanner.nextLine();
                        Item itemToAdd = new Item(itemNameToAdd, 0); // Dummy price for simplicity
                        userManager.addToWishlist(loggedInUser, itemToAdd);
                        System.out.println("Item added to wishlist: " + itemNameToAdd);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    loggedInUser = userManager.loginUser(username, "");  // Assuming the user is already logged in
                    if (loggedInUser != null) {
                        System.out.print("Enter item name to remove from wishlist: ");
                        String itemNameToRemove = scanner.nextLine();
                        Item itemToRemove = new Item(itemNameToRemove, 0); // Dummy price for simplicity
                        userManager.removeFromWishlist(loggedInUser, itemToRemove);
                        System.out.println("Item removed from wishlist: " + itemNameToRemove);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    loggedInUser = userManager.loginUser(username, "");  // Assuming the user is already logged in
                    if (loggedInUser != null) {
                        System.out.print("Enter feedback: ");
                        String feedback = scanner.nextLine();
                        userManager.provideFeedback(loggedInUser, feedback);
                        System.out.println("Feedback provided: " + feedback);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    loggedInUser = userManager.loginUser(username, "");  // Assuming the user is already logged in
                    if (loggedInUser != null) {
                        System.out.print("Enter number of items to order: ");
                        int numItems = Integer.parseInt(scanner.nextLine());
                        List<Item> items = new ArrayList<>();
                        for (int i = 0; i < numItems; i++) {
                            System.out.print("Enter item name: ");
                            String itemName = scanner.nextLine();
                            System.out.print("Enter item price: ");
                            double itemPrice = Double.parseDouble(scanner.nextLine());
                            items.add(new Item(itemName, itemPrice));
                        }
                        System.out.print("Enter payment amount: ");
                        double paymentAmount = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter payment method: ");
                        String paymentMethod = scanner.nextLine();
                        Payment payment = new Payment(paymentAmount, paymentMethod);
                        System.out.print("Enter shipping address: ");
                        String shippingAddress = scanner.nextLine();
                        System.out.print("Enter contact details: ");
                        contactDetails = scanner.nextLine();
                        ShippingInfo shippingInfo = new ShippingInfo(shippingAddress, contactDetails);
                        Order order = userManager.placeOrder(loggedInUser, items);
                        userManager.makePayment(order, payment);
                        userManager.addShippingInfo(order, shippingInfo);
                        orderContext.processOrder(order); // Initial order status
                        orderContext.setOrderStatus(new PaymentReceived());
                        orderContext.processOrder(order); // Payment received status
                        orderContext.setOrderStatus(new OrderShipped());
                        orderContext.processOrder(order); // Order shipped status
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 9:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
