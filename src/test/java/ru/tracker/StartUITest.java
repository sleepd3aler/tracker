package ru.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenCreateItem() {
        Input input = new MockInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction(),
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Input input = new MockInput(
                new String[]{"0", "1", "Replaced name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ReplaceAction(),
                new ExitAction(),
        };
        tracker.add(new Item("Item name"));
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Replaced name");
    }

    @Test
    void whenReplaceItemIsFailed() {
        Input input = new MockInput(
                new String[]{"0", "2", "Replaced name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ReplaceAction(),
                new ExitAction(),
        };
        tracker.add(new Item("Item name"));
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isNotEqualTo("Replaced name");
    }

    @Test
    void whenDeleteItem() {
        Input input = new MockInput(
                new String[]{"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction(),
        };
        tracker.add(new Item("Item name"));
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll().length).isZero();
    }

    @Test
    void whenDeleteItemIsFailed() {
        Input input = new MockInput(
                new String[]{"0", "2", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction(),
        };
        tracker.add(new Item("Item name"));
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll().length).isNotZero();
    }
}