package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {

    private Set<String> words;
    private int duplicates;

    public PersonalDuplicateRemover() {
        words = new HashSet<String>();
        duplicates = 0;
    }

    @Override
    // stores a characterString if it's not a duplicate.
    public void add(String characterString) {
        if (words.contains(characterString)) {
            duplicates++;
        }
        words.add(characterString);
    }

    @Override
    // returns the number of detected duplicates.
    public int getNumberOfDetectedDuplicates() {
        return duplicates;
    }

    @Override
    // returns an object which implements the interface Set<String>. Object should
    // have all unique characterStrings (no duplicates!). If there are no unique
    // characterStrings, method returns an empty set.
    public Set<String> getUniqueCharacterStrings() {
        return new HashSet<String>(words);
    }

    @Override
    // removes stored characterStrings and resets the amount of detected duplicates.
    public void empty() {
        words.clear();
    }

}