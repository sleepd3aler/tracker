package ru.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Выбрать: ");
            String msg = "Введите имя: ";
            int select = input.askInt(msg);
            if (select == 0) {
                System.out.println("==Создание заявки==");
                String name = input.askStr(msg);
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавлена заявка: " + item);
            } else if (select == 1) {
                System.out.println("=== Вывод всех заявок ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок");
                }
            } else if (select == 2) {
                System.out.println("== Изменение заявки ==");
                msg = "Введите ID заявки: ";
                System.out.println(msg);
                int id = input.askInt(msg);
                msg = "Введите имя новой заявки: ";
                String newName = input.askStr(msg);
                Item newItem = new Item(newName);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Замена прошла успешно, " + "Актуальная заявка: " + newItem);
                } else {
                    System.out.println("Введите корректный ID: ");
                }

            } else if (select == 3) {
                System.out.println("== Удаление заявки ==");
                System.out.println("Введите ID заявки:");
                int deleteId = input.askInt(msg);
                boolean isValid = tracker.findById(deleteId) != null;
                if (isValid) {
                    tracker.delete(deleteId);
                    System.out.println("Заявка №: " + deleteId + "удалена успешно");
                } else {
                    System.out.println("Такой заявки не существует");
                }
            } else if (select == 4) {
                System.out.println("== Просмотр заявки ==");
                System.out.println("Введите id заявки для просмотра заявки: ");
                int currentId = input.askInt(msg);
                Item currentItem = tracker.findById(currentId);
                if (currentItem != null) {
                    System.out.println(currentItem);
                } else {
                    System.out.println("Такой заявки не существует");
                }
            } else if (select == 5) {
                System.out.println("== Просмотр заявок ==");
                System.out.println("Введите имя для поиска заявок: ");
                String currentName = input.askStr(msg);
                Item[] foundedItems = tracker.findByName(currentName);
                if (foundedItems.length == 0) {
                    System.out.println("Заявки не найдены");
                } else {
                    for (Item item : foundedItems) {
                        System.out.println(item);
                    }
                }
            } else if (select == 6) {
                System.out.println("Программа завершена!");
                run = false;
            } else {
                run = false;
            }
        }
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

