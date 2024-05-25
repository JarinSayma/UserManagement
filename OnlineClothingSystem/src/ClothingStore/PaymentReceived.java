package ClothingStore;



public class PaymentReceived implements OrderStatus {
    @Override
    public void handle(OrderContext context) {
        System.out.println("Payment received. Preparing for shipment.");
    }
}
