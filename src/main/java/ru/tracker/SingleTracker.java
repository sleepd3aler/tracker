package ru.tracker;

public final class SingleTracker {
    private Tracker tracker = new Tracker();
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
        return this.tracker.add(item);
    }

    public boolean replace(int id, Item item) {
        return this.tracker.replace(id, item);
    }

    public void delete(int id) {
        this.tracker.delete(id);
    }

    public Item findById(int id) {
        return this.tracker.findById(id);
    }

    public Item[] findByName(String name) {
        return this.tracker.findByName(name);
    }

    public Item[] findAll() {
        return this.tracker.findAll();
    }

}
