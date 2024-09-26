package org.sep26.models;

public class Car {

    public Car(int plate, String model, String make) {
        this.plate = plate;
        this.model = model;
        this.make = make;
    }

    public int plate;
    public String model, make;

    @Override
    public String toString() {
        return "Car{" +
                "plate=" + plate +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                '}';
    }
}
