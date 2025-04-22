package ru.tracker;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemSortTest {

    @Test
    void whenAscByNameSort() {
        List<Item> items = Arrays.asList(
                new Item("Make coffee"),
                new Item("Fix Car"),
                new Item("Clear car")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Clear car"),
                new Item("Fix Car"),
                new Item("Make coffee"));

        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenDescByNameSort() {
        List<Item> items = Arrays.asList(
                new Item("Make coffee"),
                new Item("Fix car"),
                new Item("Clear car")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item("Make coffee"),
                new Item("Fix car"), new Item("Clear car"));
        assertThat(items).isEqualTo(expected);
    }
}
