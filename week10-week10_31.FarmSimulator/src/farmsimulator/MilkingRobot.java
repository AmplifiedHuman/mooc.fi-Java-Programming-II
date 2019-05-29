package farmsimulator;

public class MilkingRobot {

    private BulkTank tank;

    public BulkTank getBulkTank() {
        return tank;
    }

    public void setBulkTank(BulkTank tank) {
        this.tank = tank;
    }

    public void milk(Milkable milkable) {
        if (tank == null) {
            throw new IllegalStateException();
        }
        tank.addToTank(milkable.milk());
    }
}