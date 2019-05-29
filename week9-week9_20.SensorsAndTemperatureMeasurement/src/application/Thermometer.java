package application;

import java.util.Random;

public class Thermometer implements Sensor {
    
    private boolean status;

    public Thermometer() {
        status = false;
    }

    @Override
    public boolean isOn() {
        return status;
    }

    @Override
    public void on() {
        status = true;
    }

    @Override
    public void off() {
        status = false;
    }

    @Override
    public int measure() {
        if (!status) {
            throw new IllegalStateException();
        }
        return new Random().nextInt(61) - 30;
    }

}