package farmsimulator;

public class BulkTank {
    
    private double capacity;
    private double volume;

    public BulkTank(double capacity) {
        this.capacity = capacity;
        volume = 0;
    }

    public BulkTank() {
        this(2000);
    }

    public double getCapacity() {
        return capacity;
    }

    public double getVolume() {
        return volume;
    }

    public double howMuchFreeSpace() {
        return capacity - volume;
    }

    public void addToTank(double amount) {
        if (amount < 0) {
            return;
        }
        if (amount >= howMuchFreeSpace()) {
            volume = capacity;
        } else {
            volume += amount;
        }
    }

    public double getFromTank(double amount) {
        if (amount < 0) {
            return 0;
        }
        
        double total = 0;
        if (amount >= volume) {
            total = volume;
            volume = 0;
        } else {
            total = amount;
            volume -= amount;
        }
        return total;
    }

    @Override
    public String toString() {
        return Math.ceil(volume) + "/" + Math.ceil(capacity);
    }
}