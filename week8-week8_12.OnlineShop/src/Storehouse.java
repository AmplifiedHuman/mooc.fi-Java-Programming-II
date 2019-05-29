import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storehouse {

    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;

    public Storehouse() {
        prices = new HashMap<String, Integer>();
        stocks = new HashMap<String, Integer>();
    }

    public void addProduct(String product, int price, int stock) {
        prices.put(product, price);
        stocks.put(product, stock);
    }

    public int price(String product) {
        if (prices.containsKey(product)) {
            return prices.get(product);
        }
        return -99;
    }

    public int stock(String product) {
        if (stocks.containsKey(product)) {
            return stocks.get(product);
        }
        return 0;
    }

    public boolean take(String product) {
        if (stocks.containsKey(product) && stocks.get(product) > 0) {
            int stock = stocks.get(product);
            stocks.replace(product, stock - 1);
            return true;
        }
        return false;
    }

    public Set<String> products() {
        return prices.keySet();
    }
}