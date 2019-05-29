package boxes;

import java.util.HashSet;
import java.util.Set;

public class MaxWeightBox extends Box {

    private int maxWeight;
    private Set<Thing> things;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        things = new HashSet<Thing>();
    }

    public int calculateWeight() {
        int sum = 0;
        for (Thing thing : things) {
            sum += thing.getWeight();
        }
        return sum;
    }

    @Override
    public void add(Thing thing) {
        if (thing == null) {
            return;
        }

        if (thing.getWeight() + calculateWeight() <= maxWeight) {
            things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return things.contains(thing);
    }

}