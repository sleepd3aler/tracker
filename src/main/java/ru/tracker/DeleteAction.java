package ru.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("== Удаление заявки ==");
        int deleteId = input.askInt("Введите ID заявки:");
        boolean isValid = tracker.findById(deleteId) != null;
        if (isValid) {
            tracker.delete(deleteId);
            System.out.println("Заявка №: " + deleteId + " удалена успешно");
        } else {
            System.out.println("Такой заявки не существует");
        }
        return true;
    }
}
