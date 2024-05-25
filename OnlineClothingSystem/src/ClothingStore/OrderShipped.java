package ClothingStore;



public class OrderShipped implements OrderStatus {
    @Override
    public void handle(OrderContext context) {
        System.out.println("Order shipped. Delivery in progress.");
    }
}
