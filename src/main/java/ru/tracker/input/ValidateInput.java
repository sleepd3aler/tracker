package ru.tracker.input;

import java.util.Scanner;

public class ValidateInput extends ConsoleInput {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int askInt(String question) throws NumberFormatException {
        System.out.println(question);
        int value = -1;
        try {
            value = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Пожалуйста, введите корректные данные");
        }
        return value;
    }
}

