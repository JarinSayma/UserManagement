package ClothingStore;


public class OrderCreated implements OrderStatus {
    @Override
    public void handle(OrderContext context) {
        System.out.println("Order created. Waiting for payment.");
    }
}
