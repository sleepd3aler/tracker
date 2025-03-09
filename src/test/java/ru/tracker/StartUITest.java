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
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName()).isEqualTo(expected.getName());
        created = tracker.findAll()[1];
        expected = new Item("Fix Bug");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    void whenAdd3Items() {
        String[] answers = {"Fix PC", "Call police", "Find cat"};
        Input input = new MockInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        Item[] created = tracker.findAll();
        Item expected1 = new Item("Fix PC");
        Item expected2 = new Item("Call police");
        Item expected3 = new Item("Find cat");
        assertThat(created[0].getName()).isEqualTo(expected1.getName());
        assertThat(created[1].getName()).isEqualTo(expected2.getName());
        assertThat(created[2].getName()).isEqualTo(expected3.getName());
    }

    @Test
    void whenAdd3ItemsIdIsUnique() {
        String[] answers = {"Fix PC", "Call police", "Find cat"};
        Input input = new MockInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        Item[] created = tracker.findAll();
        int uniqId = created[0].getId();
        int uniqId2 = created[1].getId();
        int uniqId3 = created[2].getId();
        assertThat(uniqId).isNotEqualTo(uniqId2);
        assertThat(uniqId).isNotEqualTo(uniqId3);
    }

    @Test
    void whenAddItem1() {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }
}
