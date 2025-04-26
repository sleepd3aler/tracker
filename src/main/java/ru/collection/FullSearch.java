package ru.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public HashSet<String> extractNumber(List<Task> tasks) {
        HashSet<String> result = new HashSet<>();
        for (Task task : tasks) {
            result.add(task.getNumber());
        }
        return result;
    }
}
