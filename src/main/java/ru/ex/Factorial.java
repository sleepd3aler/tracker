package ru.ex;
//
public class Factorial {
    public  int calc(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число должно быть положительным");
        }
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Factorial().calc(-1));

    }
}
