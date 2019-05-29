public class Calculator {

    private int value;

    public Calculator() {
        value = 0;
    }

    public void add(int x) {
        value += x;
    }

    public void subtract(int x) {
        value -= x;
    }

    public void reset() {
        value = 0;
    }

    public int getValue() {
        return value;
    }
}