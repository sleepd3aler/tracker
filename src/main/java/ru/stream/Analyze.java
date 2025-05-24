package ru.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .mapToDouble(Subject::score)
                .average().getAsDouble();
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.name(), pupil.subjects().stream()
                        .mapToDouble(Subject::score)
                        .average().getAsDouble()))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        Map<String, Integer> subjects = subjectsTotalScore(stream);
        return subjects.entrySet().stream()
                .map(subject ->
                        new Tuple(subject.getKey(), (double) subject.getValue() / subjects.size()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        List<Tuple> list = stream.map(pupil ->
                        new Tuple(pupil.name(),
                                pupil.subjects().stream().mapToDouble(Subject::score)
                                        .sum()))
                .toList();
        return list.stream()
                .max(Comparator.comparing(Tuple::score))
                .get();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        Map<String, Integer> subjects = subjectsTotalScore(stream);
        return subjects.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(subject -> new Tuple(subject.getKey(), subject.getValue()))
                .max(Comparator.comparing(Tuple::score))
                .get();
    }

    private static Map<String, Integer> subjectsTotalScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.toMap(Subject::name,
                        Subject::score,
                        Integer::sum));
    }
}
