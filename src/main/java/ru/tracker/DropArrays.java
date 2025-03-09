package ru.tracker;

import java.util.Arrays;

public class DropArrays {
    public static void main(String[] args) {
        String[] names = {"Petr", null, "Ivan", "Stepan", "Fedor"};
        String[] rsl = new String[names.length];
        int size = 0;
        for (String name : names) {
            if (name != null) {
                rsl[size] = name;
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        for (String s : rsl) {
            System.out.println(s);
        }
        System.arraycopy(names, 2, names, 1, 3);
        System.out.println(Arrays.toString(names));
    }
}
