package ru.oop;

public class OverloadRunner {
    public void print(String name, int age, boolean allow) {
        System.out.println("Your name: " + name);
        System.out.println("Your age: " + age);
        System.out.println("Your allow: " + allow);
    }

    public void print(String name, double age, boolean allow) {
        System.out.println("Your name: " + name);
        System.out.println("Your age: " + age);
        System.out.println("Your allow: " + allow);
    }
            // Такого нужно избегать (см. первый метод и метод ниже)

    public void print(boolean allow, int age, String name) {
        System.out.println("Your name: " + name);
        System.out.println("Your age: " + age);
        System.out.println("Your allow: " + allow);
    }

    public void print(String name, int age) {
        System.out.println("Your name: " + name);
        System.out.println("Your age: " + age);
    }
}
