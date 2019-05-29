package file;

import java.io.File;
import java.util.Scanner;

public class Analysis {

    private File file;

    public Analysis(File file) {
        this.file = file;
    }

    public int lines() {
        Scanner reader;
        try {
            reader = new Scanner(file, "UTF-8");
        } catch (Exception e) {
            System.out.println("Cannot open file.");
            return -1;
        }
        
        int count = 0;
        while (reader.hasNextLine()) {
            count++;
            reader.nextLine();
        }

        reader.close();
        return count;
    }

    public int characters() {
        Scanner reader;
        try {
            reader = new Scanner(file, "UTF-8");
        } catch (Exception e) {
            System.out.println("Cannot open file.");
            return -1;
        }
        // We need lines to calculate the newlines because nextLine does not read newline characters
        int characters = 0;
        int lines = 0;
        while (reader.hasNextLine()) {
            characters += reader.nextLine().length();
            lines++;
        }

        reader.close();
        return characters + lines;
    }
}