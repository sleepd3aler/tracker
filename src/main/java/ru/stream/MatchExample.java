package ru.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean result = strings
                .stream()
                .noneMatch("Шесть"::contains);
        System.out.println(result);

        boolean anyMatchRes = strings.stream()
                .anyMatch(element -> element.endsWith("ь"));
        System.out.println(anyMatchRes);

        boolean allMatchRes = strings.stream()
                .allMatch(element -> element.startsWith("Три"));
        System.out.println(allMatchRes);

    }
}
