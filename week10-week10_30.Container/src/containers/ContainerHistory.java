package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContainerHistory {

    private List<Double> history;

    public ContainerHistory() {
        history = new ArrayList<Double>();
    }

    public void add(double situation) {
        history.add(situation);
    }

    public void reset() {
        history.clear();
    }

    public double maxValue() {
        if (history.isEmpty()) {
            return 0;
        }
        return Collections.max(history);
    }

    public double minValue() {
        if (history.isEmpty()) {
            return 0;
        }
        return Collections.min(history);
    }

    public double average() {
        if (history.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double i : history) {
            sum += i;
        }
        return sum / history.size();
    }

    public double greatestFluctuation() {
        if (history.isEmpty() || history.size() == 1) {
            return 0;
        }
        
        double maxFluctuation = 0;
        for (int i = 1; i < history.size(); i++) {
            double currentFluctuation = Math.abs(history.get(i) - history.get(i - 1));
            if (currentFluctuation > maxFluctuation) {
                maxFluctuation = currentFluctuation;
            }
        }
        return maxFluctuation;
    }

    public double variance() {
        if (history.isEmpty() || history.size() == 1) {
            return 0;
        }
        double sumOfSquares = 0;
        double mean = average();
        for (double i : history) {
            sumOfSquares += Math.pow(i - mean, 2);
        }
        return sumOfSquares / (history.size() - 1);
    }

    @Override
    public String toString() {
        return history.toString();
    }

}