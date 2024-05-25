package ClothingStore;


import java.util.List;

public class Order {
    private List<Item> items;
    private double totalPrice;

    public Order(List<Item> items, double totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
