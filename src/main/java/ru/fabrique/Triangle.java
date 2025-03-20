package ru.fabrique;

public class Triangle implements Shape {
    private double a;
    private double h;

    public Triangle(double a, double b) {
        this.a = a;
        this.h = b;
    }

    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return "   *" + ln
                + "  * *" + ln
                + " *   *" + ln
                + "*******";
    }

    @Override
    public double square() {
        return 0.5 * a * h;
    }

}
