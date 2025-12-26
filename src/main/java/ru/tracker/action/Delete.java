package ru.tracker.action;

import ru.tracker.Store;
import ru.tracker.input.Input;
import ru.tracker.output.Output;

public class Delete implements UserAction {
    private final Output output;

    public Delete(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("== Удаление заявки ==");
        int deleteId = input.askInt("Введите ID заявки:");
        boolean isValid = tracker.findById(deleteId) != null;
        if (isValid) {
            tracker.delete(deleteId);
            output.println("Заявка №: " + deleteId + " удалена успешно");
        } else {
            output.println("Такой заявки не существует");
        }
        return true;
    }
}
