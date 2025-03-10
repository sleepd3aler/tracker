package ru.tracker;
//
public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Показать заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("== Просмотр заявок ==");
        String currentName = input.askStr("Введите имя для поиска заявок: ");
        Item[] foundedItems = tracker.findByName(currentName);
        if (foundedItems.length == 0) {
            System.out.println("Заявки не найдены");
        } else {
            for (Item item : foundedItems) {
                System.out.println(item);
            }
        }
        return true;
    }
}
