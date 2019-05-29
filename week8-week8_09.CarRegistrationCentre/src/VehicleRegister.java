import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegister {

    private HashMap<RegistrationPlate, String> owners;

    public VehicleRegister() {
        owners = new HashMap<RegistrationPlate, String>();
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if (owners.containsKey(plate)) {
            return false;
        }
        owners.put(plate, owner);
        return true;
    }

    public String get(RegistrationPlate plate) {
        return owners.get(plate);
    }

    public boolean delete(RegistrationPlate plate) {
        if (owners.containsKey(plate)) {
            owners.remove(plate);
            return true;
        }
        return false;
    }

    public void printRegistrationPlates() {
        for (RegistrationPlate plate : owners.keySet()) {
            System.out.println(plate);
        }
    }

    public void printOwners() {
        ArrayList<String> names = new ArrayList<String>();
        for (String name : owners.values()) {
            if (!names.contains(name)) {
                names.add(name);
                System.out.println(name);
            }
        }
    }


}