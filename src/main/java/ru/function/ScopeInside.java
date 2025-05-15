package ru.function;

import java.util.function.Supplier;

public class ScopeInside {
    private static String first = "Гав";
    private static String second = "Муу";

    public static void main(String[] args) {
        String name = echo(
                () -> {
                    second = "Мяу";
                    return first + second;
                }
        );
        System.out.println(name);

        String ayyyy = "ayyyy";
        ayyyy = "aaaa";
        String temp = ayyyy;
        String test = echo(() -> temp);
        System.out.println(ayyyy);
        System.out.println(test);
    }

    private static String echo(Supplier<String> supplier) {
        String sound = supplier.get();
        return sound + " " + sound + " " + sound;
    }
}

