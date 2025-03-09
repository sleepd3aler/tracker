package ru.oop;

public class Bird extends Animal {

    public Bird() {
    }

    public void initialize(String name, int age, double weight) {
        this.setName(name);
        this.setAge(age);
        this.setWeight(weight);
    }

    @Override
    public void makeSound() {
        System.out.println("Ку - ку");
    }

    public void fly() {
        System.out.println("Я лечу");
    }

    @Override
    public void eat() {
        System.out.println("Я ем");
    }
}
