package ru.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-1, -2, 0, 0, 33, -666, 7777, 8, 9, 10);
        List<Integer> positive = numbers.stream().filter(n -> n > 0).toList();
        System.out.println(positive);
    }
}
