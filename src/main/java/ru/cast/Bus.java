package ru.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getName() + " передвигается по трассе.");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Вместимость пассажиров: " + passengers);
    }
}
