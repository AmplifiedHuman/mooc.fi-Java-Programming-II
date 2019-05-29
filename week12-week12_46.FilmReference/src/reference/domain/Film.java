package reference.domain;

public class Film {
    private String name;

    public Film(String name) {
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
        if (!(o instanceof Film)) {
            return false;
        }
        Film compare = (Film) o;
        return name.equals(compare.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}