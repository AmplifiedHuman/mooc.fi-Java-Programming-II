public class Calculator {

    private Reader reader;
    private int calculations;

    public Calculator() {
        reader = new Reader();
        calculations = 0;
    }

    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
                calculations++;
            } else if (command.equals("difference")) {
                difference();
                calculations++;
            } else if (command.equals("product")) {
                product();
                calculations++;
            }
        }
        statistics();
    }

    private void sum() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        System.out.println("sum of the values " + (value1 + value2));
    }

    private void difference() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        System.out.println("difference of the values " + (value1 - value2));
    }

    private void product() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        System.out.println("product of the values " + (value1 * value2));
    }

    private void statistics() {
        System.out.println("Calculations done " + calculations);
    }
}