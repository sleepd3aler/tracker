package ru.tracker;

import java.util.List;

public final class SingleTracker {
    private MemTracker memTracker = new MemTracker();
    private static SingleTracker instance = null;

    private SingleTracker() {

    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return this.memTracker.add(item);
    }

    public boolean replace(int id, Item item) {
        return this.memTracker.replace(id, item);
    }

    public void delete(int id) {
        this.memTracker.delete(id);
    }

    public Item findById(int id) {
        return this.memTracker.findById(id);
    }

    public List<Item> findByName(String name) {
        return this.memTracker.findByName(name);
    }

    public List<Item> findAll() {
        return this.memTracker.findAll();
    }

}
