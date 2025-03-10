package ru.tracker;
//
public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Показать заявку по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("== Просмотр заявки ==");
        int currentId = input.askInt("Введите id заявки для просмотра заявки: ");
        Item currentItem = tracker.findById(currentId);
        if (currentItem != null) {
            System.out.println(currentItem);
        } else {
            System.out.println("Такой заявки не существует");
        }
        return true;
    }
}
