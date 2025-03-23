package store;

import java.util.List;

public class InventoryManager extends Employee {

    public InventoryManager(String name, int id, String department, double salary, Store store) {
        super(name, id, salary, store);
    }

    public void addProduct(String name, double price, String category, int stock) {
        List<Product> new_inventory = getStore().getInventory();
        new_inventory.add(new Product(name, price, category, stock));
        getStore().setInventory(new_inventory);
        System.out.println("Product " + name + " added to store inventory by " + getName() + "(" + getId() + ")");
    }

    // TODO refactor
    public void removeProduct(String name) {
        List<Product> inventory = getStore().getInventory();
        inventory.removeIf(product -> product.getNombre().equals(name));
        System.out.println("Producto " + name + " eliminado del inventario de la tienda por " + getName() + "(" + getId() + ")");
    }

    // TODO refactor
    public void updateStock(String name, int newStock) {
        for (Product product : getStore().getInventory()) {
            if (product.getNombre().equals(name)) {
                product.setStock(newStock);
                System.out.println("Producto " + name + " actualizado por " + getName() + "(" + getId() + ")");
                return;
            }
        }
    }

    // TODO refactor
    public void printInventory() {
        getStore().getInventory().forEach(product ->
                System.out.println(product.getNombre() + " - " + product.getCategoria() + " - $" + product.getPrecio() + " - Stock: " + product.getStock())
        );
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
        List<Product> inventory = getStore().getInventory();
        double totalValue = 0;
        int totalStock = 0;

        for (Product product : inventory) {
            if ((categoryFilter.equals("all") || product.getCategoria().equals(categoryFilter)) &&
                    product.getPrecio() >= minPrice && product.getPrecio() <= maxPrice) {

                if (applyDiscount) {
                    applyCategoryDiscount(product);
                }

                printStockStatus(product);
            }
            totalStock += product.getStock();
            totalValue += product.getPrecio() * product.getStock();
        }

        System.out.println("Resumen: " + totalStock + " productos en stock, valor total: $" + totalValue);
        System.out.println("Inventario procesado por " + getName() + "(" + getId() + ")");
    }

    private void applyCategoryDiscount(Product product) {
        switch (product.getCategoria()) {
            case "electronics":
                product.setPrecio(product.getPrecio() * 0.9);
                break;
            case "clothing":
                product.setPrecio(product.getPrecio() * 0.85);
                break;
            default:
                product.setPrecio(product.getPrecio() * 0.95);
                break;
        }
    }

    private void printStockStatus(Product product) {
        if (product.getStock() == 0) {
            System.out.println("[AGOTADO] " + product.getNombre());
        } else if (product.getStock() < 5) {
            System.out.println("[BAJO STOCK] " + product.getNombre() + " - Restantes: " + product.getStock());
        } else {
            System.out.println("[OK] " + product.getNombre() + " - Precio: $" + product.getPrecio() + " - Stock: " + product.getStock());
        }
    }

}
