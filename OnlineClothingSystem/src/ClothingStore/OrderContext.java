package ClothingStore;



public class OrderContext {
    private OrderStatus orderStatus;

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void processOrder(Order order) {
        if (orderStatus != null) {
            orderStatus.handle(this);
        }
    }
}
