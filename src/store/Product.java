package store;

// TODO refactor
public class Product {
    public String n;    // nombre
    public double p;    // precio
    public String c;    // categoria
    public int s;       // stock

    // TODO refactor
    public Product(String n, double p, String c, int s) {
        this.n = n;
        this.p = p;
        this.c = c;
        this.s = s;
    }
}