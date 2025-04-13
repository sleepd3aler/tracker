package ru.hashmap;

import java.util.*;
import ru.bank.Label;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            labels.add(new Label(pupil.name(), sum / pupil.subjects().size()));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (!map.containsKey(subject.name())) {
                    map.put(subject.name(), subject.score());
                } else {
                    map.put(subject.name(), map.get(subject.name()) + subject.score());
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            labels.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> students = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double studentScore = 0;
            for (Subject subject : pupil.subjects()) {
                studentScore += subject.score();
            }
            students.add(new Label(pupil.name(), studentScore));
        }
        students.sort(Comparator.naturalOrder());
        return students.get(students.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> subjects = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (!map.containsKey(subject.name())) {
                    map.put(subject.name(), subject.score());
                } else {
                    map.put(subject.name(), map.get(subject.name()) + subject.score());
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            subjects.add(new Label(entry.getKey(), entry.getValue()));
    }
        subjects.sort(Comparator.naturalOrder());
        return subjects.get(subjects.size() - 1);
}
}
