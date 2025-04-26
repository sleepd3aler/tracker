package ru.oop;

public class Main {
    public static void main(String[] args) {
        Truck truck = new Truck();
        truck.setBrand("Volvo");
        truck.setModel("Volvo McDonald");
        truck.setType("SuperType");
        truck.setMaxSpeed(250);
        truck.setPassengers(3);
        System.out.println("Brand: " + truck.getBrand());
        System.out.println("Model: " + truck.getModel());
        System.out.println("Type: " + truck.getType());
        System.out.println("Max speed: " + truck.getMaxSpeed());
        System.out.println("Passengers: " + truck.getPassengers());
        truck.accelerate();
        truck.steer();
        truck.brake();
    }
}
