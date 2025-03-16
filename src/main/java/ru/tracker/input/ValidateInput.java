package ru.tracker.input;
//
public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) throws NumberFormatException {
        do {
            try {
                return super.askInt(question);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста введите корректные данные");
            }
        } while (true);
    }
}


