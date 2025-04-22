package ru.collection;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.*;

public class TreeSort {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>(Collections.reverseOrder());
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        System.out.println(numbers);

    }
}
