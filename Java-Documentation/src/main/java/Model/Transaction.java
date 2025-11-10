package Model;

public class Transaction {
    private int id;
    private String item;
    private int quantity;
    private double price;

    public Transaction(int id, String item, int quantity, double price) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotal() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return id + "," + item + "," + quantity + "," + price;
    }
}
