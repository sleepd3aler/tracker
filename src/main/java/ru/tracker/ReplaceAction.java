package ru.tracker;
//
public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("== Изменение заявки ==");
        int id = input.askInt("Введите ID заявки: ");
        String newName = input.askStr("Введите имя новой заявки: ");
        Item newItem = new Item(newName);
        if (tracker.replace(id, newItem)) {
            System.out.println("Замена прошла успешно, " + "Актуальная заявка: " + newItem);
        } else {
            System.out.println("Введите корректный ID: ");
        }
        return true;
    }
}
