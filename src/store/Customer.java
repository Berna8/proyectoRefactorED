package store;

public class Customer {
    private Order order;

    public Customer(Order order) {
        this.order = order;
    }

    // TODO refactor
    public String getOrderPayMethod() {
        return order.getPayment().getPayMethod().getType();
    }
}
