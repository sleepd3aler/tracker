package ru.tracker.action;

import ru.tracker.Store;
import ru.tracker.input.Input;
import ru.tracker.output.Output;

public class DeleteAllItems implements UserAction {
    private Output output;

    public DeleteAllItems(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Удалить все заявки";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        tracker.deleteAllItems();
        output.println("== Все заявки удалены успешно. ===");
        return true;
    }
}
