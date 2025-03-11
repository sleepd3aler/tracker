package ru.tracker;

public class DeleteAction implements UserAction {
    private final Output output;

    public DeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("== Удаление заявки ==");
        int deleteId = input.askInt("Введите ID заявки:");
        boolean isValid = tracker.findById(deleteId) != null;
        if (isValid) {
            tracker.delete(deleteId);
            output.println("Заявка №: " + deleteId + " удалена успешно");
        } else {
            output.println("Такой заявки не существует");
        }
        return true;
    }
}
