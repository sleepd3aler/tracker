package ru.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по рельсам.");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Вместимость пассажиров: " + passengers);
    }
}
//