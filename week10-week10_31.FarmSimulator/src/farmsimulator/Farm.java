package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive {

    private List<Cow> cows;
    private String owner;
    private Barn barn;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        cows = new ArrayList<Cow>();
    }

    public void addCow(Cow cow) {
        cows.add(cow);
    }

    public void manageCows() {
        barn.takeCareOf(cows);
    }

    public void installMilkingRobot(MilkingRobot robot) {
        if (robot != null) {
            barn.installMilkingRobot(robot);
        }
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public void liveHour() {
        for (Cow cow : cows) {
            cow.liveHour();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Farm owner: ");
        sb.append(owner);
        sb.append("\nBarn bulk tank: ");
        sb.append(barn.getBulkTank());
        sb.append("\nAnimals:\n");
        for (Cow cow : cows) {
            sb.append("        ");
            sb.append(cow);
            sb.append('\n');
        }
        return sb.toString();
    }

}