package ru.ex;

public class Factorial {
    public  int calc(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Число должно быть положительным и больше нуля");
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Factorial().calc(-0));

    }
}
