package ru.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int minus) {
        return x - minus;
    }

    public int divide(int divide) {
        return x / divide;
    }

    public int sumAllOperation(int result) {
        return sum(result) + multiply(result) + divide(result) + minus(result);
    }

    public static void main(String[] args) {
        int sum = sum(5);
        System.out.println("Sum result: " + sum);
        Calculator calculator = new Calculator();
        int multiply = calculator.multiply(2);
        System.out.println("Multiply result: " + multiply);
        int minus = minus(5);
        System.out.println("Minus result: " + minus);
        int divide = calculator.divide(5);
        System.out.println("Divide result: " + divide);
        int sumAllOperation = calculator.sumAllOperation(5);
        System.out.println("Sum of all operation: " + sumAllOperation);
    }
}
