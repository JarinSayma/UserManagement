package ClothingStore;

public class OrderShipped implements OrderStatus {
    @Override
    public void processOrder(Order order) {
        System.out.println("Order shipped. Tracking details sent to the customer.");
    }
}
