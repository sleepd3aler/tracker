package ru.stream;

import java.util.Arrays;
import java.util.List;

public class SelectionExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        List<String> result = strings.stream()
                .skip(strings.size() - 1)
                .limit(2)
                .toList();
        String resultString = strings
                .stream()
                .skip(5)
                .limit(2)
                .findFirst()
                .orElse("По умолчанию");
        System.out.println(result);

        System.out.println(resultString);
    }
}
