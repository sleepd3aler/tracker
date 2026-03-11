package ru.tracker.action;

import ru.tracker.Item;
import ru.tracker.Store;
import ru.tracker.input.Input;
import ru.tracker.output.Output;

public class CreateManyItems implements UserAction {
    private final Output output;

    public CreateManyItems(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Добавить несколько заявок";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("== Создание новых заявок ==");
        int amount = input.askInt("Введите колличество заявок: ");
        for (int i = 0; i < amount; i++) {
            tracker.add(
                    new Item(i, "N : " + i));
        }
        output.println("== Добавлено: " + amount + " заявок ==");
        return true;
    }
}
