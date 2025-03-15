package ru.tracker.input;

import java.util.Scanner;

public class ValidateInput extends ConsoleInput {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int askInt(String question) throws NumberFormatException {
        System.out.println(question);
        if (scanner.hasNextInt()) {
            return Integer.parseInt(scanner.nextLine());
        } else {
            scanner.nextLine();
            throw new NumberFormatException("Пожалуйста, введите корректные данные");
        }
    }
}

