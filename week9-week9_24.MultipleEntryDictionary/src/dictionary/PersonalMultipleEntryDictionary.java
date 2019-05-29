package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {

    private Map<String, Set<String>> dict;

    public PersonalMultipleEntryDictionary() {
        dict = new HashMap<String, Set<String>>();
    }

    @Override
    // Adds a new entry to a word, maintaining the old ones
    public void add(String word, String entry) {
        if (dict.get(word) == null) {
            dict.put(word, new HashSet<String>());
        }
        dict.get(word).add(entry);
    }

    @Override
    // Returns a Set object, with all the entries of the word, or a null
    // reference, if the word is not in the dictionary
    public Set<String> translate(String word) {
        if (dict.get(word) == null) {
            return null;
        }
        return new HashSet<String>(dict.get(word));
    }

    @Override
    // Removes a word and all its entries from the dictionary
    public void remove(String word) {
        if (dict.get(word) != null) {
            dict.remove(word);
        }
    }

}