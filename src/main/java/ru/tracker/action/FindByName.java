package ru.tracker.action;

import java.util.List;
import ru.tracker.input.Input;
import ru.tracker.Item;
import ru.tracker.output.Output;
import ru.tracker.Tracker;

public class FindByName implements UserAction {
    private final Output output;

    public FindByName(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Просмотр заявок ===");
        String currentName = input.askStr("Введите имя для поиска заявок: ");
        List<Item> foundedItems = tracker.findByName(currentName);
        if (foundedItems.size() == 0) {
            output.println("Заявки не найдены");
        } else {
            for (Item item : foundedItems) {
                output.println(item);
            }
        }
        return true;
    }
}
