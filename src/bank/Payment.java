package bank;

public class Payment {
    private PayMethod payMethod;
    private double price;

    public Payment(PayMethod payMethod, double price) {
        this.payMethod = payMethod;
        this.price = price;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public double getPrice() {
        return price;
    }

    public boolean executePayment() {
        /// se simula que se consultan los datos del banco para la transacción, no tocar
        return true;
    }

}
