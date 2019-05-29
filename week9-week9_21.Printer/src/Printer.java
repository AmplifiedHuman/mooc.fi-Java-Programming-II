import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Printer {

    private List<String> lines;

    public Printer(String fileName) throws Exception {
        
        File f = new File(fileName);
        Scanner reader = new Scanner(f, "UTF-8");
        lines = new ArrayList<String>();

        while (reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }

        reader.close();
    }

    public void printLinesWhichContain(String word) {
        for (String line : lines) {
            if (line.contains(word)) {
                System.out.println(line);
            }
        }
    }
}