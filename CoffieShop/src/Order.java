import java.util.ArrayList;
import java.util.List;

class Order {
    private String customerName;
    private List<String> items;
    private double total;

    public Order(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<>();
        this.total = 0;
    }

    public void addItem(String itemName, double price) {
        items.add(itemName);
        total += price;
    }

    public void printOrderDetails() {
        System.out.println("\nOrder for: " + customerName);
        System.out.println("Items Ordered:");
        for (String item : items) {
            System.out.println("- " + item);
        }
        System.out.println("Total Amount: $" + total);
    }
}