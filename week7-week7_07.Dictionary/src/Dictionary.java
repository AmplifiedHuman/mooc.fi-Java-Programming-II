import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

    private HashMap<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<String, String>();
    }

    public String translate(String word) {
        return dictionary.get(word);
    }

    public void add(String word, String translation) {
        dictionary.put(word, translation);
    }

    public int amountOfWords() {
        return dictionary.size();
    }

    public ArrayList<String> translationList() {
        ArrayList<String> translations = new ArrayList<String>();
        for (String key : dictionary.keySet()) {
            translations.add(key + " = " + dictionary.get(key));
        }
        return translations;
    }
}