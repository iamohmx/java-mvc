package org.sep26.controllers;

import org.sep26.models.Car;

public class LogicController {
    public void insertCar(int plate, String model, String make) {
        // Insert car logic here
        System.out.println("CAR Logic.insertCar() called");
        Car car = new Car(plate, model, make);
        CarController carController = new CarController();
        carController.insertCar(car);
    }
}
