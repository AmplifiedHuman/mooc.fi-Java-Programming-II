
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        // printWithSmileys("Method");
        // printWithSmileys("Beerbottle");
        printWithSmileys("Inter");
    }

    private static void printWithSmileys(String characterString) {
        if (characterString.length() % 2 == 0) {
            printSmileyLine(characterString.length() / 2 + 3);
            System.out.println(":) " + characterString + " :)");
            printSmileyLine(characterString.length() / 2 + 3);
        } else {
            printSmileyLine((characterString.length() + 1) / 2 + 3);
            System.out.println(":) " + characterString + "  :)");
            printSmileyLine((characterString.length() + 1) / 2 + 3);
        }
    }

    private static void printSmileyLine(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(":)");
        }
        System.out.println("");
    }

}
