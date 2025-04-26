package ru.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] elements : array) {
            for (int number : elements) {
                list.add(number);
            }
        }
        return list;
    }
}
