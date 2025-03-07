package store;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager extends Employee {
    private List<Product> inventory = new ArrayList<>();

    public InventoryManager(String name, int id, String department, double salary) {
        super(name, id, department, salary);
    }

    public void addProduct(String name, double price, String category, int stock) {
        inventory.add(new Product(name, price, category, stock));
    }

    // TODO refactor
    public void removeProduct(String name) {
        for (Product p : inventory) {
            if (p.n.equals(name)) {
                inventory.remove(p);
                break;
            }
        }
    }

    // TODO refactor
    public void updateStock(String name, int newStock) {
        for (Product p : inventory) {
            if (p.n.equals(name)) {
                p.s = newStock;
            }
        }
    }

    // TODO refactor
    public void printInventory() {
        for (Product p : inventory) {
            System.out.println(p.n + " - " + p.c + " - $" + p.p + " - Stock: " + p.s);
        }
    }

    @Override
    public void conductMeeting() {}

    @Override
    public void submitReport() {}

    @Override
    public void approveBudget() {}

    // TODO refactor
    public void processInventory(String categoryFilter, double minPrice, double maxPrice, boolean applyDiscount) {
        System.out.println("Procesando inventario...");

        for (Product p : inventory) {
            if (p.c.equals(categoryFilter) || categoryFilter.equals("all")) {
                if (p.p >= minPrice && p.p <= maxPrice) {
                    if (applyDiscount) {
                        if (p.c.equals("electronics")) {
                            p.p *= 0.9;  // 10% de descuento
                        } else if (p.c.equals("clothing")) {
                            p.p *= 0.85; // 15% de descuento
                        } else {
                            p.p *= 0.95; // 5% de descuento
                        }
                    }

                    if (p.s == 0) {
                        System.out.println("[AGOTADO] " + p.n);
                    } else if (p.s < 5) {
                        System.out.println("[BAJO STOCK] " + p.n + " - Quedan " + p.s);
                    } else {
                        System.out.println("[OK] " + p.n + " - Precio: $" + p.p + " - Stock: " + p.s);
                    }
                }
            }
        }

        int totalStock = 0;
        double totalValue = 0;

        for (Product p : inventory) {
            totalStock += p.s;
            totalValue += p.p * p.s;
        }

        System.out.println("Resumen: " + totalStock + " productos en stock, valor total: $" + totalValue);
    }

}
