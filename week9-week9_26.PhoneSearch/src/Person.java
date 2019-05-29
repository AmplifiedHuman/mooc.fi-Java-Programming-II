import java.util.HashSet;
import java.util.Set;

public class Person implements Comparable<Person> {

    private String name;
    private String address;
    private Set<String> numbers;

    public Person(String name) {
        this.name = name;
        address = "";
        numbers = new HashSet<String>();
    }

    public void addAddress(String street, String city) {
        address = street + " " + city;
    }

    public void addNumber(String number) {
        numbers.add(number);
    }

    public String getAddress() {
        return address;
    }

    public Set<String> getNumbers() {
        return numbers;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}