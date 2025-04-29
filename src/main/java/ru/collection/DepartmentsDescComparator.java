package ru.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftString = left.split("/");
        String[] rightString = right.split("/");
        int result = rightString[0].compareTo(leftString[0]);
        return result == 0 ? left.compareTo(right) : result;
    }
}

