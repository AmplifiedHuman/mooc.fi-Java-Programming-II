import java.util.Scanner;

public class UserInterface {

    private PhoneBook phoneBook;
    private Scanner reader;

    public UserInterface(Scanner reader) {
        phoneBook = new PhoneBook();
        this.reader = reader;
    }

    public void start() {
        intro();
        System.out.print("\ncommand: ");
        String command = reader.nextLine();
        while (!command.equals("x")) {
            int operation = Integer.parseInt(command);
            switch(operation) {
                case 1:
                    addNumber();
                    break;
                case 2:
                    phoneSearchByName();
                    break;
                case 3:
                    nameSearchByNumber();
                    break;
                case 4:
                    addAddress();
                    break;
                case 5:
                    printInfo();
                    break;
                case 6:
                    deleteInfo();
                    break;
                case 7:
                    filteredSearchResults();
                    break;
                default:
                    System.out.println("Unknown operation.");
                    break;
            }
            System.out.print("\ncommand: ");
            command = reader.nextLine();            
        }
    }

    private void intro() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
    }

    private void addNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();
        phoneBook.addPhoneNumber(name, number);
    }

    private void phoneSearchByName() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        phoneBook.printPhoneSearchByName(name);
    }

    private void nameSearchByNumber() {
        System.out.print("number: ");
        String number = reader.nextLine();
        phoneBook.printNameSearchByNumber(number);
    }

    private void addAddress() {
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();
        phoneBook.addAddress(name, street, city);
    }

    private void printInfo() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        phoneBook.printInfo(name);
    }

    private void deleteInfo() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        phoneBook.deleteInfo(name);
    }

    private void filteredSearchResults() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        phoneBook.printFilteredSearchResults(keyword);
    }
}