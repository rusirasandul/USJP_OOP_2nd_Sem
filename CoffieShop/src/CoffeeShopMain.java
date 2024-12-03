import java.util.ArrayList;
import  java.util.List;
import java.util.Scanner;

public class CoffeeShopMain {
    private static List<MenuItem> menu = new ArrayList<>();

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Initialize menu
    menu.add(new MenuItem("Espresso", 2.5, 10));
    menu.add(new MenuItem("Latte", 3.5, 8));
    menu.add(new MenuItem("Cappuccino", 4.0, 6));
    menu.add(new MenuItem("Tea", 1.5, 12));

    while (true) {
        System.out.println("\n=== Coffee Shop Menu ===");
        displayMenu();
        System.out.println("\nOptions:");
        System.out.println("1. Place an Order");
        System.out.println("2. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            placeOrder(scanner);
        } else if (choice == 2) {
            System.out.println("Thank you for visiting!");
            break;
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    scanner.close();
}

private static void displayMenu() {
    System.out.println("Menu:");
    for (int i = 0; i < menu.size(); i++) {
        System.out.println((i + 1) + ". " + menu.get(i));
    }
}

private static void placeOrder(Scanner scanner) {
    System.out.print("\nEnter your name: ");
    String customerName = scanner.nextLine();
    Order order = new Order(customerName);

    while (true) {
        System.out.println("\nSelect an item from the menu (Enter item number or 0 to finish):");
        displayMenu();
        System.out.print("Your choice: ");
        int itemNumber = scanner.nextInt();

        if (itemNumber == 0) {
            break;
        }

        if (itemNumber < 1 || itemNumber > menu.size()) {
            System.out.println("Invalid item number. Please try again.");
            continue;
        }

        MenuItem selectedItem = menu.get(itemNumber - 1);

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        if (quantity > selectedItem.getStock()) {
            System.out.println("Insufficient stock for " + selectedItem.getName());
        } else {
            selectedItem.reduceStock(quantity);
            order.addItem(selectedItem.getName(), selectedItem.getPrice() * quantity);
            System.out.println(quantity + " x " + selectedItem.getName() + " added to your order.");
        }
    }

    order.printOrderDetails();
}
}
