package ru.tracker;

import java.util.Arrays;

public class Tracker {

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
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
        return indexOf(id) == -1 ? null : items[indexOf(id)];

    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int current = indexOf(id);
        boolean rsl = current != -1;
        if (rsl) {
            item.setId(id);
            items[current] = item;
        }
        return rsl;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            int start = index + 1;
            System.arraycopy(items, start, items, index, size - 1);
            items[size - 1] = null;
            size--;
        }
    }
}