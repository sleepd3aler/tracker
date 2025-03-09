package ru.varargs;

public class Var {
    public static int findMax(int... numbers) {
        if (numbers.length == 0) throw new IllegalArgumentException("Not provided numbers");
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMax());
    }
}
