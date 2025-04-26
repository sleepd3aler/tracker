package ru.polymorph;

public class Main {
    public static void main(String[] args) {
        System.out.println("Town Car is: ");
        Vehicle townCar = new TownCar();
        townCar.changeGear();
        townCar.accelerate();
        townCar.steer();
        townCar.brake();
        townCar.refill();
        townCar.chargeBattery();

        System.out.println("Sport Car is: ");
        Vehicle sportCar = new SportCar();
        sportCar.changeGear();
        sportCar.accelerate();
        sportCar.steer();
        sportCar.brake();
        sportCar.refill();
        sportCar.chargeBattery();
        Vehicle.getDragCoefficient();

    }
}
