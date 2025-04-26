package ru.tracker;

import java.util.List;
import ru.tracker.action.*;
import ru.tracker.input.ConsoleInput;
import ru.tracker.input.Input;
import ru.tracker.input.ValidateInput;
import ru.tracker.output.ConsoleOutput;
import ru.tracker.output.Output;

public class StartUI {
    public StartUI(Output output) {
        this.output = output;
    }

    private final Output output;

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выбрать:");
            if (select < 0 || select >= actions.size()) {
                output.println("Неверный ввод, вы можете выбрать: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        output.println("Меню:");
        for (int i = 0; i < actions.size(); i++) {
            output.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new Create(output), new FindAll(output), new Replace(output), new Delete(output), new FindById(output),
                new FindByName(output), new Exit(output)
        );

        new StartUI(output).init(input, tracker, actions);

    }
}
