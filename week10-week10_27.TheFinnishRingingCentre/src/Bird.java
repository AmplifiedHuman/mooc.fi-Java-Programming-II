
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }

    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || (getClass() != o.getClass())) {
            return false;
        }

        Bird compare = (Bird) o;
        return latinName.equals(compare.latinName) && (ringingYear == compare.ringingYear);
    }

    @Override
    public int hashCode() {
        return latinName.hashCode() + ringingYear;
    }
}
