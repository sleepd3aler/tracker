package ru.varargs;

import java.util.Arrays;

public class VarArgs {

    public static String text1(String[] strings) {
        return Arrays.toString(strings);
    }

    public static String text(String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String s : strings) {
            builder.append(s);
        }
        return builder + " Количество соединенных элементов: " + strings.length;
    }

    public static String text(int x, String... strings) {
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        for (String s : strings) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[]strings = {"aaa", "bbb", "ccc", "ddd", "eee"};
        String str = text1(strings);
        System.out.println(str);

        System.out.println(text("aaa"));
        System.out.println(text("aaa", "bbb", "ccc"));
        System.out.println(text("aaa", "bbb", "ccc", "ddd", "eee"));
        System.out.println(text(30, "aaa", "bbb"));

    }
}
