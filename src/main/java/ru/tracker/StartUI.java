package ru.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime time = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM.EEEE.yyyy HH:mm:ss");
        String dateTime = time.format(formatter);
        System.out.println(dateTime);
    }
}
