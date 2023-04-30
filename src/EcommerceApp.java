import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EcommerceApp {
    private Map<String, Product> products;

    public EcommerceApp() {
        this.products = new HashMap<>();
    }

    public void save_product(String product_id,
                             String product_name,
                             double product_price) {
        Product product = new Product(product_id, product_name, product_price);
        products.put(product_id, product);
    }

    public void purchase_product(String product_id,
                                 double price,
                                 int quantity) {
        if (products.containsKey(product_id)) {
            Purchase purchase = new Purchase(price, quantity);
            products.get(product_id).getPurchaseHistory().add(purchase);
            int newQuantity = products.get(product_id).getQuantity() + quantity;
            products.get(product_id).setQuantity(newQuantity);
        }
    }

    public void order_product(String product_id, int quantity) {
        int newQuantity = products.get(product_id).getQuantity() - quantity;
        products.get(product_id).setQuantity(newQuantity);

    }

    public int get_quantity_of_product(String product_id) {
        return products.get(product_id).getQuantity();
    }

    public double get_average_price(String product_id) {
        double fullPrice = 0;
        int totalQuantity = 0;
        List<Purchase> purchaseHistory = products.get(product_id).getPurchaseHistory();
        for (var purchase : purchaseHistory) {
            fullPrice += purchase.getPrice() * purchase.getQuantity();
            totalQuantity += purchase.getQuantity();
        }
        return fullPrice / totalQuantity;
    }

    public double get_product_profit(String product_id) {
        double totalRevenue = 0;
        double totalCost = 0;
        List<Purchase> purchaseHistory = products.get(product_id).getPurchaseHistory();
        double productPrice = products.get(product_id).getProduct_price();
        for (var purchase : purchaseHistory) {
            totalRevenue += purchase.getPrice() * purchase.getQuantity();
            totalCost += productPrice * purchase.getQuantity();
        }
        return totalRevenue - totalCost;
    }

    public String get_fewest_product() {
        int minQuantity = Integer.MAX_VALUE;
        String minProductName = "";
        for (var product : products.values()) {
            if (product.getQuantity() < minQuantity) {
                minQuantity = product.getQuantity();
                minProductName = product.getProduct_name();
            }
        }
        return minProductName;
    }

    public String get_most_popular_product() {
        int maxNumOrders = Integer.MIN_VALUE;
        String maxProductName = "";
        for (var product : products.values()) {
            int numOrders = product.getPurchaseHistory().size();
            if (numOrders > maxNumOrders) {
                maxNumOrders = numOrders;
                maxProductName = product.getProduct_name();
            }
        }
        return maxProductName;
    }

    public void get_orders_report() {
        System.out.println(products.toString());
    }

    public void export_orders_report(String csvFileName) {
        String eol = System.getProperty("line.separator");
        try (Writer writer = new FileWriter(csvFileName)) {
            for (Map.Entry<String, Product> entry : products.entrySet()) {
                writer.append(entry.getKey())
                        .append(',')
                        .append( entry.getValue().toString())
                        .append(eol);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    @Override
    public String toString() {
        return "EcommerceApp{" +
                "products=" + products +
                '}';
    }
}