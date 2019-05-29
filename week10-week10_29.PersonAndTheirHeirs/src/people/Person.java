package people;
public class Person {

    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        sb.append("\n  ");
        sb.append(address);
        return sb.toString();
    }
}