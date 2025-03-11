package ru.tracker;

public class ReplaceAction implements UserAction {
    private final Output output;

    public ReplaceAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("== Изменение заявки ==");
        int id = input.askInt("Введите ID заявки: ");
        String newName = input.askStr("Введите имя новой заявки: ");
        Item newItem = new Item(newName);
        if (tracker.replace(id, newItem)) {
            output.println("Замена прошла успешно, " + "Актуальная заявка: " + newItem);
        } else {
            output.println("Введите корректный ID: ");
        }
        return true;
    }
}
