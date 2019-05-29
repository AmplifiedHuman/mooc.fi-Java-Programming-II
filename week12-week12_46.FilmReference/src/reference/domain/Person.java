package reference.domain;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) {
            return false;
        }
        Person compare = (Person) o;
        return name.equals(compare.name);
    }

    @Override 
    public int hashCode() {
        return name.hashCode();
    }
}