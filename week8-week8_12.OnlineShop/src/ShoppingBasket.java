import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {

    private Map<String, Purchase> cart;

    public ShoppingBasket() {
        cart = new HashMap<String, Purchase>();
    }

    public void add(String product, int price) {
        if (cart.containsKey(product + price)) {
            cart.get(product + price).increaseAmount();
        } else {
            cart.put(product + price, new Purchase(product, 1, price));
        }
    }

    public int price() {
        int sum = 0;
        for (Purchase purchase : cart.values()) {
            sum += purchase.price();
        }
        return sum;
    }

    public void print() {
        for (Purchase purchase : cart.values()) {
            System.out.println(purchase);
        }
    }
}