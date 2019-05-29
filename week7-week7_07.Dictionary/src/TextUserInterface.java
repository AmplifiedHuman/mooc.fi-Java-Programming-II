import java.util.Scanner;

public class TextUserInterface {

    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        System.out.println("Statement:");
        intro();
        while (true) {
            System.out.print("Statement: ");
            String command = reader.nextLine();
            if (command.equals("quit")) {
                System.out.println("Cheers!");
                break;
            } else if (command.equals("add")) {
                this.add();
            } else if (command.equals("translate")) {
                this.translate();
            } else {
                System.out.println("Unknown statement");
            }
            System.out.println("");
        }
    }

    private void intro() {
        System.out.println(" add - adds a word pair to the dictionary");
        System.out.println(" translate - asks a word and prints its translation");
        System.out.println(" quit - quit the text user interface\n");
    }

    private void add() {
        System.out.print("In Finnish: ");
        String finnish = reader.nextLine();
        System.out.print("Translation: ");
        String english = reader.nextLine();
        dictionary.add(finnish, english);
    }

    private void translate() {
        System.out.print("Give a word: ");
        String word = reader.nextLine();
        System.out.println("Translation: " + dictionary.translate(word));
    }
}