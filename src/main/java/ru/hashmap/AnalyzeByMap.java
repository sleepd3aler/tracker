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
        Map<String, Integer> subjectTotals = sumScoresBySubject(pupils);
        for (Map.Entry<String, Integer> entry : subjectTotals.entrySet()) {
            labels.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return labels;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> subjects = new ArrayList<>();
        Map<String, Integer> subjectTotals = sumScoresBySubject(pupils);
        for (Map.Entry<String, Integer> entry : subjectTotals.entrySet()) {
            subjects.add(new Label(entry.getKey(), entry.getValue()));
        }
        subjects.sort(Comparator.naturalOrder());
        return subjects.get(subjects.size() - 1);
    }

    private static Map<String, Integer> sumScoresBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int currentScore = map.getOrDefault(subject.name(), 0);
                map.put(subject.name(), currentScore + subject.score());
            }
        }
        return map;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> score = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double studentScore = 0;
            for (Subject subject : pupil.subjects()) {
                studentScore += subject.score();
            }
            score.add(new Label(pupil.name(), studentScore));
        }
        score.sort(Comparator.naturalOrder());
        return score.get(score.size() - 1);
    }
}
