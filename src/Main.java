import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EcommerceApp ecommerceApp = new EcommerceApp();
        System.out.println("Welcome !");
        System.out.println("You can choose a commands :");
        System.out.println("1) save_product");
        System.out.println("2) purchase_product");
        System.out.println("3) order_product");
        System.out.println("4) get_quantity_of_product");
        System.out.println("5) get_average_price");
        System.out.println("6) get_product_profit");
        System.out.println("7) get_fewest_product");
        System.out.println("8) get_most_popular_product");
        System.out.println("9) get_orders_report");
        System.out.println("10) export_orders_report");
        System.out.println("11) exit");
        while (true) {
            String command = scanner.nextLine();

            switch (command) {
                case "save_product":
                    System.out.println("enter product id :");
                    String id = scanner.nextLine();
                    System.out.println("enter product name :");
                    String name = scanner.nextLine();
                    System.out.println("enter product price :");
                    double price = scanner.nextDouble();
                    ecommerceApp.save_product(id, name, price);
                    break;
                case "purchase_product":
                    System.out.println("enter product id :");
                    String productId = scanner.nextLine();
                    System.out.println("enter product price :");
                    double productPrice = scanner.nextDouble();
                    System.out.println("enter product quantity :");
                    int quantity = scanner.nextInt();
                    ecommerceApp.purchase_product(productId, productPrice, quantity);
                    break;
                case "order_product":
                    System.out.println("enter product id :");
                    String productId1 = scanner.nextLine();
                    System.out.println("enter product quantity :");
                    int quantity1 = scanner.nextInt();
                    ecommerceApp.order_product(productId1, quantity1);
                    break;
                case "get_quantity_of_product":
                    System.out.println("enter product id :");
                    String productId2 = scanner.nextLine();
                    System.out.println(ecommerceApp.get_quantity_of_product(productId2));
                    break;
                case "get_average_price":
                    System.out.println("enter product id :");
                    String productId3 = scanner.nextLine();
                    System.out.println(ecommerceApp.get_average_price(productId3));
                    break;
                case "get_product_profit":
                    System.out.println("enter product id :");
                    String productId4 = scanner.nextLine();
                    System.out.println(ecommerceApp.get_product_profit(productId4));
                    break;
                case "get_fewest_product":
                    System.out.println(ecommerceApp.get_fewest_product());
                    break;
                case "get_most_popular_product":
                    System.out.println(ecommerceApp.get_most_popular_product());
                    break;
                case "get_orders_report":
                    ecommerceApp.get_orders_report();
                    break;
                case "export_orders_report":
                    System.out.println("enter csvFile name (for example: writer.csv)");
                    String csvFile = scanner.nextLine();
                    ecommerceApp.export_orders_report(csvFile);
                    break;

                case "exit":
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You can choose a commands :");
                    break;

            }
        }
    }}