import java.util.ArrayList;
import java.util.HashMap;

public class Airport {

    private ArrayList<Flight> flights;
    private HashMap<String, Airplane> planes;

    public Airport() {
        this.flights = new ArrayList<Flight>();
        this.planes = new HashMap<String, Airplane>();
    }

    public void addAirplane(String ID, int capacity) {
        planes.put(ID, new Airplane(ID, capacity));
    }

    public void addFlight(String ID, String departure, String destination) {
        if (planes.keySet().contains(ID)) {
            flights.add(new Flight(planes.get(ID), departure, destination));
        } else {
            System.out.println("There is no such airplane.");
        }
    }

    public void printAirplanes() {
        for (Airplane plane : planes.values()) {
            System.out.println(plane);
        }
    }

    public void printFlights() {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    public void searchAirplane(String ID) {
        if (planes.containsKey(ID)) {
            System.out.println(planes.get(ID));
        } else {
            System.out.println("There is no such airplane.");
        }
    }
}