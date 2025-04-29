package ru.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        for (int i = 0; i < 2; i++) {
            char leftChar = left.charAt(i);
            char rightChar = right.charAt(i);
            result = Character.compare(rightChar, leftChar);
            if (leftChar != rightChar) {
                return result;
            }
            result = left.compareTo(right);
        }
        return result;
    }
}

