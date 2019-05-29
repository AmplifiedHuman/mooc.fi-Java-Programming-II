
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        HashMap<String, String> names = new HashMap<String, String>();
        names.put("matti", "mage");
        names.put("mikael", "mixu");
        names.put("arto", "arppa");
        System.out.println(names.get("mikael"));

    }

}
