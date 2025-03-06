package ru.cast;

public class AirBus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getName() + " передвигается в воздухе.");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Вместимость пассажиров: " + passengers);
    }
}
//