package ru.stream;

import java.util.Arrays;
import java.util.List;

public class MapToIntExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        strings.stream()
                .mapToInt(Integer::parseInt)
                .filter(integer -> integer % 2 == 0)
                .forEach(System.out::println);
    }
}
