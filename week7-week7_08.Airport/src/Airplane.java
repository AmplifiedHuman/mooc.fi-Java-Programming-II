public class Airplane {

    private String ID;
    private int capacity;

    public Airplane(String ID, int capacity) {
        this.ID = ID;
        this.capacity = capacity;
    }

    public String getID() {
        return ID;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        //G-OWAC (101 ppl)
        return ID + " (" + capacity + " ppl)";
    }
}