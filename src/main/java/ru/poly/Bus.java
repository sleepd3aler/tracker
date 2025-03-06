package ru.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("Автобус начал движение");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Пассажиров в автобусе: " + passengers);
    }

    @Override
    public double priceOf(double fuel) {
        return 95.5 * fuel;
    }
}
