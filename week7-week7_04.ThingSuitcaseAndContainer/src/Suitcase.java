import java.util.ArrayList;

public class Suitcase {

    private ArrayList<Thing> things;
    private final int maxWeight;
    private int totalWeight;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
        this.totalWeight = 0;
    }

    public void addThing(Thing thing) {
        if (thing.getWeight() + totalWeight <= maxWeight) {
            things.add(thing);
            totalWeight += thing.getWeight();
        }
    }

    public void printThings() {
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }

    public int totalWeight() {
        return this.totalWeight;
    }

    public Thing heaviestThing() {
        if (things.isEmpty()) {
            return null;
        }
        Thing maxThing = things.get(0);
        for (Thing thing : things) {
            if (thing.getWeight() > maxThing.getWeight()) {
                maxThing = thing;
            }
        }
        return maxThing;
    }

    @Override
    public String toString() {
        if (things.isEmpty()) {
            return "empty (0 kg)";
        }
        if (things.size() == 1) {
            return things.size() + " thing (" + totalWeight + " kg)";
        }
        return things.size() + " things (" + totalWeight + " kg)";
    }
}