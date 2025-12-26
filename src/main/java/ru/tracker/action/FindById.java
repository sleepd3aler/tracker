package ru.tracker.action;

import ru.tracker.Item;
import ru.tracker.Store;
import ru.tracker.input.Input;
import ru.tracker.output.Output;

public class FindById implements UserAction {
    private final Output output;

    public FindById(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявку по id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Просмотр заявки ===");
        int currentId = input.askInt("Введите id заявки для просмотра заявки: ");
        Item currentItem = tracker.findById(currentId);
        if (currentItem != null) {
            output.println(currentItem);
        } else {
            output.println("Такой заявки не существует");
        }
        return true;
    }
}
