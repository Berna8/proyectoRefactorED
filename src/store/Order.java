package store;

import bank.PayMethod;
import bank.Payment;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private String customerName;
    private String address;
    private List<Product> products;
    private double totalPrice;
    private Payment payment;

    public Order(String customerName, String address, List<Product> products) {
        this.customerName = customerName;
        this.address = address;
        this.products = products;
        this.totalPrice = calculateTotal(products);
        this.payment = new Payment(new PayMethod("VISA"), totalPrice);
    }

    public List<Product> getProducts() {
        return new LinkedList<Product>(products);
    }

    public Payment getPayment() {
        return payment;
    }

    public void printReceipt() {
        System.out.println("Cliente: " + customerName);
        System.out.println("Dirección: " + address);
        System.out.println("Productos:");
        for (Product p : products) {
            System.out.println("- " + p.n + " (" + p.c + "): $" + p.p);
        }
        System.out.println("Total: $" + totalPrice);
    }

    private double calculateTotal(List<Product> products) {
        double total = 0;
        for (Product p : products) {
            total += p.p;
        }
        return total;
    }
}
