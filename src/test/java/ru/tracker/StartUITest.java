package ru.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {

    @Test
    void whenAddItem() {
        String[] answers = {"Fix PC", "Fix Bug"};
        Input input = new MockInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        String expected = "Fix PC";
        String expected2 = "Fix Bug";
        assertThat(tracker.findAll()[0].getName()).isEqualTo(expected);
        assertThat(tracker.findAll()[1].getName()).isEqualTo(expected2);
    }

    @Test
    void whenAdd3Items() {
        String[] answers = {"Fix PC", "Call police", "Find cat"};
        Input input = new MockInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        String expected = "Fix PC";
        String expected2 = "Call police";
        String expected3 = "Find cat";
        assertThat(tracker.findAll()[0].getName()).isEqualTo(expected);
        assertThat(tracker.findAll()[1].getName()).isEqualTo(expected2);
        assertThat(tracker.findAll()[2].getName()).isEqualTo(expected3);

    }

    @Test
    void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "edited item"
        };
        StartUI.replaceItem(new MockInput(answers), tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName()).isEqualTo("edited item");
    }

    @Test
    void whenReplaceItemFailed() {
       Tracker tracker = new Tracker();
       Item item = new Item("new item");
       tracker.add(item);
       String[] answers = {"2", "edited item"};
       StartUI.replaceItem(new MockInput(answers), tracker);
       Item edited = tracker.findById(item.getId());
       assertThat(edited.getName()).isNotEqualTo("edited item");
    }
}