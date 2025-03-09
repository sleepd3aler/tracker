package ru;

import java.util.Calendar;

public class Format {
    public static void getGreeting(String name, int age) {
        System.out.printf("Привет, Я %s!, мне  %d лет%n", name, age);
    }

    public static void getGreetingAndDateTime(String name) {
        Calendar instance = Calendar.getInstance();
        System.out.printf("Привет, %s! Текущая дата: %tF, Текущее время: %tT%n", name, instance, instance);

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
