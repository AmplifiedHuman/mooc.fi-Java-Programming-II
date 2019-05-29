import java.util.ArrayList;

public class Container {

    private final int maxWeight;
    private ArrayList<Suitcase> suitcases;
    private int totalWeight;

    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
        this.suitcases = new ArrayList<Suitcase>();
        this.totalWeight = 0;
    }

    public void addSuitcase(Suitcase suitcase) {
        if (suitcase.totalWeight() + totalWeight <= maxWeight) {
            suitcases.add(suitcase);
            totalWeight += suitcase.totalWeight();
        }
    }

    public void printThings() {
        for (Suitcase suitcase : suitcases) {
            suitcase.printThings();
        }
    }

    @Override
    public String toString() {
        if (suitcases.isEmpty()) {
            return "empty (0 kg)";
        }
        if (suitcases.size() == 1) {
            return suitcases.size() + " suitcase (" + totalWeight + " kg)";
        }
        return suitcases.size() + " suitcases (" + totalWeight + " kg)";
    }

}