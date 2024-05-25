package ClothingStore;

public class OrderContext {
    private OrderStatus orderStatus;

    public OrderContext() {
        this.orderStatus = new OrderCreated();
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void processOrder(Order order) {
        orderStatus.processOrder(order);
    }
}
