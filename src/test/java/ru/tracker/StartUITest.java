package ru.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenCreateItem() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output),
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[]{"0", "1", "Replaced name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output),
        };
        tracker.add(new Item("Item name"));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Replaced name");
    }

    @Test
    void whenReplaceItemIsFailed() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[]{"0", "2", "Replaced name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output),
        };
        tracker.add(new Item("Item name"));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isNotEqualTo("Replaced name");
    }

    @Test
    void whenDeleteItem() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[]{"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output),
        };
        tracker.add(new Item("Item name"));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().length).isZero();
    }

    @Test
    void whenDeleteItemIsFailed() {
        Input input = new MockInput(
                new String[]{"0", "2", "1"}
        );
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output),
        };
        tracker.add(new Item("Item name"));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().length).isNotZero();
    }

    @Test
    void whenExit() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(output),
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );

    }
}