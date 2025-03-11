package ru.tracker;

public class FindByIdAction implements UserAction {
    private final Output output;

    public FindByIdAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявку по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
