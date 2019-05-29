package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing {

    private int max;
    private List<Thing> things;

    public Box(int maximumCapacity) {
        max = maximumCapacity;
        things = new ArrayList<Thing>();
    }

    public boolean addThing(Thing thing) {
        if (getVolume() + thing.getVolume() <= max) {
            things.add(thing);
            return true;
        }
        return false;
    }

    @Override
    public int getVolume() {
        int total = 0;
        for (Thing thing : things) {
            total += thing.getVolume();
        }
        return total;
    }
}