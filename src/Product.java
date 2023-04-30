import java.util.ArrayList;
import java.util.List;

public class Product {
    private String product_id;
    private String product_name;
    private double product_price;
    private int quantity = 0;
    private List<Purchase> purchaseHistory;

    public Product(String product_id, String product_name, double product_price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.purchaseHistory= new ArrayList<>();
    }

    public Product() {
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPurchaseHistory(List<Purchase> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id='" + product_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                ", quantity=" + quantity +
                ", purchaseHistory=" + purchaseHistory +
                '}';
    }
}
