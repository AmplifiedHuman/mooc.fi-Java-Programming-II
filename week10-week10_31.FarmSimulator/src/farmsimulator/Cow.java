package farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive {

    private static final String[] NAMES = new String[] { "Anu", "Arpa", "Essi", "Heluna", "Hely", "Hento", "Hilke",
            "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo", "Jaana", "Jami", "Jatta", "Laku", "Liekki", "Mainikki", "Mella",
            "Mimmi", "Naatti", "Nina", "Nyytti", "Papu", "Pullukka", "Pulu", "Rima", "Soma", "Sylkki", "Valpu",
            "Virpi" };

    private String name;
    private double capacity;
    private double amount;

    public Cow(String name) {
        this.name = name;
        capacity = generateCapacity();
        amount = 0;
    }

    public Cow() {
        this(generateName());
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void liveHour() {
        double random = new Random().nextInt(14) + 7;
        amount += random / 10;
        if (amount > capacity) {
            amount = capacity;
        }
    }

    @Override
    public double milk() {
        double total = amount;
        amount = 0;
        return total;
    }

    @Override
    public String toString() {
        return name + " " + Math.ceil(amount) + "/" + capacity;
    }

    private static String generateName() {
        return NAMES[new Random().nextInt(NAMES.length)];
    }

    private static int generateCapacity() {
        return 15 + new Random().nextInt(26);
    }

}