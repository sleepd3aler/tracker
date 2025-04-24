package ru.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = Math.abs(left.length() - right.length());
        if (right.isEmpty()) {
            return result;
        }
        for (int i = 0; i < left.length(); i++) {
            char leftChar = left.charAt(i);
            char rightChar = right.charAt(i);
            result = Character.compare(leftChar, rightChar);
            if (result == 0) {
                result = Integer.compare(left.length(), right.length());
            } else {
                break;
            }
        }
        return result;
    }
}
