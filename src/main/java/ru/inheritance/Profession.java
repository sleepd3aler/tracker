package ru.inheritance;

public class Profession {

    private boolean degree;

    public Profession(boolean degree) {
        this.degree = degree;
    }

    public static void test() {
        System.out.println("hello");
    }

    public void nonStaticMethod() {
        System.out.println("non static method");
    }
}
