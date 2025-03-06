package ru.cast;

public class TransportUsage {
    public static void main(String[] args) {
        Vehicle airBus = new AirBus();
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle[] vehicles = {airBus, bus, train};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.passengers(30);
        }
    }
}
