package people;

public class Student extends Person {

    private int credits = 0;

    public Student(String name, String address) {
        super(name, address);
        credits = 0;
    }

    public void study() {
        credits++;
    }
    
    public int credits() {
        return credits;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n  credits " + credits);
        return sb.toString();
    }
}