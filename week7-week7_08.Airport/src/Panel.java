import java.util.Scanner;

public class Panel {

    private Airport airport;
    private Scanner reader;

    public Panel(Airport airport, Scanner reader) {
        this.airport = airport;
        this.reader = reader;
    }

    private void intro() {
        System.out.println("Choose operation:");
        System.out.println("[1] Add airplane");
        System.out.println("[2] Add flight");
        System.out.println("[x] Exit");
    }

    public void start() {
        System.out.println("Airport panel");
        System.out.println("--------------------\n");

        while (true) {
            intro();
            System.out.print("> ");
            String command = reader.nextLine();
            if (command.equalsIgnoreCase("x")) {
                break;
            } else if (command.equals("1")) {
                handleAddPlane();
            } else if (command.equals("2")) {
                handleAddFlight();
            } else {
                System.out.println("Unknown command.");
            }
        }
        System.out.println("");
    }

    private void handleAddPlane() {
        System.out.print("Give plane ID: ");
        String ID = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        airport.addAirplane(ID, capacity);
    }

    private void handleAddFlight() {
        System.out.print("Give plane ID: ");
        String ID = reader.nextLine();
        System.out.print("Give departure airport code: ");
        String departure = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destination = reader.nextLine();
        airport.addFlight(ID, departure, destination);
    }

}