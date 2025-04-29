package ru.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        boolean firstElems = left.charAt(0) == right.charAt(0) && left.charAt(1) == right.charAt(1);
        int result = right.compareTo(left);
        if (firstElems) {
            result = left.compareTo(right);
        }
        return result;
    }
}

