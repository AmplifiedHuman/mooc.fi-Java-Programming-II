package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {

    private File file;
    private List<String> lines;

    public WordInspection(File file) {
        this.file = file;
        this.lines = new ArrayList<String>();
        readFile();
    }

    public int wordCount() {
        System.out.println(lines.size());
        return lines.size();
    }

    public List<String> wordsContainingZ() {
        List<String> zList = new ArrayList<String>();
        for (String line : lines) {
            if (line.contains("z") || line.contains("Z")) {
                zList.add(line);
            }
        }
        return zList;
    }

    public List<String> wordsEndingInL() {
        List<String> lList = new ArrayList<String>();
        for (String line : lines) {
            if (line.endsWith("l") || line.endsWith("L")) {
                lList.add(line);
            }
        }
        return lList;
    }

    public List<String> palindromes() {
        List<String> palindromes = new ArrayList<String>();
        for (String line : lines) {
            if (line.equals(new StringBuilder(line).reverse().toString())) {
                palindromes.add(line);
            }
        }
        return palindromes;
    }

    public List<String> wordsWhichContainAllVowels() {
        List<String> vowels = new ArrayList<String>();
        for (String line : lines) {
            if (containAllVowels(line)) {
                vowels.add(line);
            }
        }
        return vowels;
    }

    private boolean containAllVowels(String word) {
        String vowels = "aeiouyäö";
        for (char ch : vowels.toCharArray()) {
            if (!word.contains(ch + "")) {
                return false;
            }
        }
        return true;
    }

    private void readFile() {
        lines.clear();
        Scanner reader;

        try {
            reader = new Scanner(file, "UTF-8");
        } catch (Exception e) {
            System.out.println("Cannot open file for reading");
            return;
        }

        while (reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }

        reader.close();
    }
}