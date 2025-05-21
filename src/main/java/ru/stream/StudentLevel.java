package ru.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .dropWhile(Student -> Student.getScore() < bound)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .collect(Collectors.toList());

    }
}
