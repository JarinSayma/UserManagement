package ClothingStore;

public class OrderCreated implements OrderStatus {
    @Override
    public void processOrder(Order order) {
        System.out.println("Order created. Waiting for payment...");
    }
}
