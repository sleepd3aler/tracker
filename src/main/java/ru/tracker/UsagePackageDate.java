package ru.tracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Текущая дата: " + currentDate);
        LocalTime currentTime = LocalTime.now();
        System.out.println("Текущее время: " + currentTime);
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Текущая дата и время до форматирования: " + currentDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String currentDateTimeString = currentDateTime.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeString);

    }
}
