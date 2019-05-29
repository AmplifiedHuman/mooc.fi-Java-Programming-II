package moving.logic;

import java.util.ArrayList;
import java.util.List;

import moving.domain.Box;
import moving.domain.Thing;

public class Packer {

    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();
        Box tempBox = new Box(boxesVolume);
        for (Thing thing : things) {
            if (!tempBox.addThing(thing)) {
                boxes.add(tempBox);
                tempBox = new Box(boxesVolume);
                tempBox.addThing(thing);
            }
        }
        // add the last box if the box is not empty
        if (tempBox.getVolume() != 0) {
            boxes.add(tempBox);
        }

        return boxes;
    }
}