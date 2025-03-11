package ru.tracker;

public class FindByNameAction implements UserAction {
    private final Output output;

    public FindByNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("== Просмотр заявок ==");
        String currentName = input.askStr("Введите имя для поиска заявок: ");
        Item[] foundedItems = tracker.findByName(currentName);
        if (foundedItems.length == 0) {
            output.println("Заявки не найдены");
        } else {
            for (Item item : foundedItems) {
                output.println(item);
            }
        }
        return true;
    }
}
