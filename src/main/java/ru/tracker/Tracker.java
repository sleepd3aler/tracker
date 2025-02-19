package ru.tracker;

import java.util.Arrays;

/**
 *          В классе Tracker должны быть методы:
 *
 * •	добавление заявок - public Item add(Item item);
 * •	получение списка всех заявок - public Item[] findAll();
 * •	получение списка по имени - public Item[] findByName(String key);
 * •	получение заявки по id - public Item findById(int id);
 *
 */

public class Tracker {
    /**
     * Массив, который содержит возможное кол-во заявлений
     */
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    /**
     * Метод public Item[] findAll() возвращает копию массива items без null элементов (без пустых ячеек).
     * Перебирать все 100 элементов не нужно. У нас есть поле size.
     * Это поле и есть размер нового массива.
     * Чтобы получить новый массив, нужно использовать метод Arrays.copyOf. Этот метод принимает два параметра: массив элементов и новый размер.
     */

    public Item[] findAll() {
        Item[] result = new Item[this.size];
        for (int index = 0; index < this.size; index++) {
            if (this.items[index] != null) {
                result[index] = this.items[index];
            }
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[this.size];
        int newSize = 0;
        for (int index = 0; index < this.size; index++) {
            if (this.items[index].getName().equals(key) && this.items[index] != null) {
                result[newSize] = this.items[index];
                newSize++;
            }
        }
        result = Arrays.copyOf(result, newSize);
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