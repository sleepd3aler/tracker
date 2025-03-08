package ru.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Выбрать: ");
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                findAllItems(tracker);
            } else if (select == 2) {
                replaceItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
            } else if (select == 6) {
                System.out.println("Программа завершена!");
                run = false;
            } else {
                run = false;
            }
        }
    }

    private static void findItemByName(Input input, Tracker tracker) {
        System.out.println("== Просмотр заявок ==");
        String currentName = input.askStr("Введите имя для поиска заявок: ");
        Item[] foundedItems = tracker.findByName(currentName);
        if (foundedItems.length == 0) {
            System.out.println("Заявки не найдены");
        } else {
            for (Item item : foundedItems) {
                System.out.println(item);
            }
        }
    }

    private static void findItemById(Input input, Tracker tracker) {
        System.out.println("== Просмотр заявки ==");
        int currentId = input.askInt("Введите id заявки для просмотра заявки: ");
        Item currentItem = tracker.findById(currentId);
        if (currentItem != null) {
            System.out.println(currentItem);
        } else {
            System.out.println("Такой заявки не существует");
        }
    }

    private static void deleteItem(Input input, Tracker tracker) {
        System.out.println("== Удаление заявки ==");
        int deleteId = input.askInt("Введите ID заявки:");
        boolean isValid = tracker.findById(deleteId) != null;
        if (isValid) {
            tracker.delete(deleteId);
            System.out.println("Заявка №: " + deleteId + " удалена успешно");
        } else {
            System.out.println("Такой заявки не существует");
        }
    }

    private static void replaceItem(Input input, Tracker tracker) {
        System.out.println("== Изменение заявки ==");
        int id = input.askInt("Введите ID заявки: ");
        String newName = input.askStr("Введите имя новой заявки: ");
        Item newItem = new Item(newName);
        if (tracker.replace(id, newItem)) {
            System.out.println("Замена прошла успешно, " + "Актуальная заявка: " + newItem);
        } else {
            System.out.println("Введите корректный ID: ");
        }
    }

    private static void findAllItems(Tracker tracker) {
        System.out.println("=== Вывод всех заявок ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище еще не содержит заявок");
        }
    }

    private static void createItem(Input input, Tracker tracker) {
        System.out.println("== Создание новой заявки ==");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавлена заявка: " + item);
    }

    private void showMenu() {
        String[] menu = {
                "Добавить новую заявку", "Показать все заявки", "Изменить заявку",
                "Удалить заявку", "Показать заявку по id", "Показать заявки по имени", "Завершить программу"
        };
        System.out.println("Меню: ");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);

    }
}
