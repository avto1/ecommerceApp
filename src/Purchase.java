public class Purchase {
    private double price;
    private int quantity;

    Purchase(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }


    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
