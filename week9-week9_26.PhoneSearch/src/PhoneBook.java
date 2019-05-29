import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, Person> nameBook;
    private Map<String, Person> phoneBook;

    public PhoneBook() {
        nameBook = new HashMap<String, Person>();
        phoneBook = new HashMap<String, Person>();
    }

    public void addPhoneNumber(String name, String number) {
        if (!nameBook.keySet().contains(name)) {
            nameBook.put(name, new Person(name));
        }
        nameBook.get(name).addNumber(number);
        phoneBook.put(number, nameBook.get(name));
    }

    public void printPhoneSearchByName(String name) {
        if (!nameBook.keySet().contains(name) || nameBook.get(name).getNumbers().isEmpty()) {
            System.out.println("  not found");
        } else {
            for (String number : nameBook.get(name).getNumbers()) {
                System.out.println(" " + number);
            }
        }
    }

    public void printNameSearchByNumber(String number) {
        if (!phoneBook.containsKey(number)) {
            System.out.println(" not found");
        } else {
            System.out.println(" " + phoneBook.get(number).getName());
        }
    }

    public void addAddress(String name, String street, String city) {
        if (!nameBook.keySet().contains(name)) {
            nameBook.put(name, new Person(name));
        }
        nameBook.get(name).addAddress(street, city);
    }

    public void printInfo(String name) {
        if (!nameBook.keySet().contains(name)) {
            System.out.println("  not found");
            return;
        }
        if (nameBook.get(name).getAddress().isEmpty()) {
            System.out.println("  address unknown");
        } else {
            System.out.println("  address: " + nameBook.get(name).getAddress());
        }
        if (nameBook.get(name).getNumbers().isEmpty()) {
            System.out.println("  phone number not found");
        } else {
            System.out.println("  phone numbers:");
            for (String number : nameBook.get(name).getNumbers()) {
                System.out.println("   " + number);
            }
        }
    }

    public void deleteInfo(String name) {
        if (!nameBook.keySet().contains(name)) {
            System.out.println("  not found");
            return;
        }
        
        for (String number : nameBook.get(name).getNumbers()) {
            phoneBook.remove(number);
        }
        nameBook.remove(name);
    }

    public void printFilteredSearchResults(String searchString) {
        List<Person> results;
        if (searchString.isEmpty()) {
            results = new ArrayList<Person>(nameBook.values());
        } else {
            results = getFilteredSearchResults(searchString);
        }

        Collections.sort(results);

        if (results.isEmpty()) {
            System.out.println(" keyword not found");
        }

        for (Person person : results) {
            System.out.println("\n " + person.getName());
            printInfo(person.getName());
        }
    }
    // Return a  list of search results
    private List<Person> getFilteredSearchResults(String searchString) {
        List<Person> results = new ArrayList<Person>();
        if (nameBook.containsKey(searchString)) {
            results.add(nameBook.get(searchString));
        }
        for (Person person : nameBook.values()) {
            if (person.getAddress().contains(searchString) || person.getName().contains(searchString)) {
                if (!results.contains(person)) {
                    results.add(person);
                }
            }
        }
        return results;
    }
}