package ru.ooa;

public class Airport {
    public static void main(String[] args) {
        AirBus airbus = new AirBus("A320");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();

        airbus = new AirBus("A380");
        System.out.println(airbus);
        airbus.printCountEngine();

        airbus.setName("A380");
        System.out.println(airbus);
        airbus.printCountEngine();
    }

}
