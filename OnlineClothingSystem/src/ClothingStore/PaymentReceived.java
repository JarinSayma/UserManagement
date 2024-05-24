package ClothingStore;

public class PaymentReceived implements OrderStatus {
    @Override
    public void processOrder(Order order) {
        System.out.println("Payment received. Processing order...");
    }
}
