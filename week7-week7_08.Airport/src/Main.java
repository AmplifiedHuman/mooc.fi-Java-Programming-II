import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Airport airport = new Airport();
        Scanner reader = new Scanner(System.in);
        Panel panel = new Panel(airport, reader);
        Service service = new Service(airport, reader);
        panel.start();
        service.start();
    }
}
