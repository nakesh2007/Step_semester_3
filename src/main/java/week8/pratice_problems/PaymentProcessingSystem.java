import java.util.*;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

interface PaymentMethod {
    boolean pay(double amount);
}

class CreditCard implements PaymentMethod {
    public boolean pay(double amount) {
        return true;
    }
}

class PayPal implements PaymentMethod {
    public boolean pay(double amount) {
        return false;
    }
}

class Order {
    List<Product> products = new ArrayList<>();
    String status = "Pending";

    void add(Product p) {
        products.add(p);
    }

    void pay(PaymentMethod method) {
        if (products.isEmpty()) {
            System.out.println("Cannot pay empty order");
            return;
        }

        double total = 0;

        for (Product p : products)
            total += p.price;

        if (method.pay(total)) {
            status = "Paid";
            System.out.println("Payment successful");
        } else {
            System.out.println("Payment failed");
        }

        System.out.println("Status: " + status);
    }
}

public class PaymentProcessingSystem {
    public static void main(String[] args) {

        Product a = new Product("Product A", 100);
        Product b = new Product("Product B", 200);
        Product c = new Product("Product C", 300);

        Order x = new Order();
        x.add(a);
        x.add(a);
        x.add(b);

        System.out.println("Customer X");
        x.pay(new CreditCard());

        Order y = new Order();

        System.out.println("Customer Y");
        y.pay(new CreditCard());

        Order z = new Order();
        z.add(c);

        System.out.println("Customer Z");
        z.pay(new PayPal());
    }
}