package ru.tracker.input;

import ru.tracker.output.Output;

public class ValidateInput implements Input {
    private final Input input;
    private final Output output;

    public ValidateInput(Output output, Input input) {
        this.input = input;
        this.output = output;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) throws NumberFormatException {
        do {
            try {
                return input.askInt(question);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста введите корректные данные");
            }
        } while (true);
    }
}


