package ru;

public class Calculator {

    public double add(double first, double second) {
        return first + second;
    }

    public double add(double first, double second, double third) {
        return add(first,
                add(second, third));
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = (int) calculator.add(1, 2);
        System.out.println(result);
        calculator.add(2, 3, 4);
        result = (int) calculator.add(3, 4, 5);
        System.out.println(result);
    }
}
