package ru.oop;

public class Jar {

    private int value;

    public Jar(int size) {
        this.value = size;
    }

    public void pour(Jar another) {
        this.value = this.value + another.value;
        another.value = 0;
    }

    public static void main(String[] args) {
        Jar first = new Jar(10);
        Jar second = new Jar(5);
        System.out.println("First: " + first.value + ". Second: " + second.value);
        first.pour(second);
        System.out.println("First: " + first.value + ". Second: " + second.value);
    }
}
