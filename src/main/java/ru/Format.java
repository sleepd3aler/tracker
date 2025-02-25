package ru;

import java.util.Calendar;

public class Format {
    public static void getGreeting(String name, int age) {
        System.out.println(String.format("Привет, Я %s!, мне  %d лет", name, age));
    }

    public static void getGreetingAndDateTime(String name) {
        Calendar instance = Calendar.getInstance();
        System.out.println(String.format("Привет, %s! Текущая дата: %tF, Текущее время: %tT", name, instance, instance));

    }

    public static void main(String[] args) {
        getGreeting("Helen", 30);
        getGreetingAndDateTime("Helen");

        //%[индекс_аргумента$][флаг(и)][ширина][.точность]спецификатор

        String s = String.format("%2$,+016.2f", 5000000.0000, 130000.000);
        System.out.println(s);
        System.out.println(s.length());
    }
}
