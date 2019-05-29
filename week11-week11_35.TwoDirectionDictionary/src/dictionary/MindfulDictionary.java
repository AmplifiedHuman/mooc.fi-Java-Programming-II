package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MindfulDictionary {

    private Map<String, String> finnishToEnglish;
    private Map<String, String> englishToFinnish;
    private File newFile;

    public MindfulDictionary() {
        finnishToEnglish = new HashMap<String, String>();
        englishToFinnish = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) {
        newFile = new File(file);
        finnishToEnglish = new HashMap<String, String>();
        englishToFinnish = new HashMap<String, String>();
    }

    public boolean load() {
        try {
            Scanner reader = new Scanner(newFile);
            String[] parts;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                parts = line.split(":");
                add(parts[1], parts[0]);
            }
            reader.close();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public void add(String word, String translation) {
        // ignore word if already been added
        if (finnishToEnglish.containsKey(word) || finnishToEnglish.containsValue(word)) {
            return;
        }
        finnishToEnglish.put(translation, word);
        englishToFinnish.put(word, translation);
    }

    public String translate(String word) {
        if (finnishToEnglish.containsKey(word)) {
            return finnishToEnglish.get(word);
        } else {
            return englishToFinnish.get(word);
        }
    }

    public void remove(String word) {
        if (finnishToEnglish.containsKey(word)) {
            String remove = finnishToEnglish.get(word);
            englishToFinnish.remove(remove);
            finnishToEnglish.remove(word);
        } else {
            String remove = englishToFinnish.get(word);
            finnishToEnglish.remove(remove);
            englishToFinnish.remove(word);
        }
    }

    public boolean save() {
        try {
            FileWriter writer = new FileWriter(newFile);
            for (String word : finnishToEnglish.keySet()) {
                writer.write(word + ":" + finnishToEnglish.get(word) + "\n");
            }
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}