import java.util.Scanner;

public class Service {

    private Airport airport;
    private Scanner reader;

    public Service(Airport airport, Scanner reader) {
        this.airport = airport;
        this.reader = reader;
    }

    private void intro() {
        System.out.println("Choose operation:");
        System.out.println("[1] Print planes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print plane info");
        System.out.println("[x] Quit");
    }

    public void start() {
        System.out.println("Flight service");
        System.out.println("--------------------\n");
        while (true) {
            intro();
            System.out.print("> ");
            String command = reader.nextLine();
            if (command.equalsIgnoreCase("x")) {
                break;
            } else if (command.equals("1")) {
                airport.printAirplanes();
            } else if (command.equals("2")) {
                airport.printFlights();
                System.out.println("");
            } else if (command.equals("3")) {
                System.out.print("Give plane ID: ");
                String ID = reader.nextLine();
                airport.searchAirplane(ID);
                System.out.println("");
            } else {
                System.out.println("Unknown command.");
            }
        }
    }
}