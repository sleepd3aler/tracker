package ru.tracker.action;
//
import ru.tracker.input.Input;
import ru.tracker.Item;
import ru.tracker.output.Output;
import ru.tracker.Tracker;

public class Replace implements UserAction {
    private final Output output;

    public Replace(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Редактирование заявки ===");
        int id = input.askInt("Введите ID заявки:");
        String newName = input.askStr("Введите имя новой заявки:");
        Item newItem = new Item(newName);
        if (tracker.replace(id, newItem)) {
            output.println("Заявка изменена успешно.");
        } else {
            output.println("Введен не существующий ID");
        }
        return true;
    }
}
