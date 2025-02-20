package ru.tracker;

import java.util.Arrays;

public class Tracker {

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item[] findAll() {
        Item[] result = new Item[this.size];
        int newSize = this.size;
        for (int index = 0; index < result.length; index++) {
            Item item = this.items[index];
                result[index] = item;
        }
        result = Arrays.copyOf(result, newSize);
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[this.size];
        int size = 0;
        for (int index = 0; index < result.length; index++) {
            Item item = this.items[index];
            if (item.getName().equals(key)) {
                result[size++] = item;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}