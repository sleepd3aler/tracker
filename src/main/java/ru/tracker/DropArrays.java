package ru.tracker;

import java.util.Arrays;

public class DropArrays {
    public static void main(String[] args) {
        String[] names = {"Petr", null, "Ivan", "Stepan", null};
        String[] rsl = new String[names.length];
        int size = 0;
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (name != null) {
                rsl[size] = name;
                size++;
            }
        }
        rsl = Arrays.copyOf(rsl, size);
        for (String s : rsl) {
            System.out.println(s);
        }
    }
}
