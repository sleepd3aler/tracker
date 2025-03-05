package ru.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Выбрать: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("==Создание заявки==");
                System.out.println("Введите имя: ");
                String name = scanner.nextLine();
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
                System.out.println("Введите ID заявки: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Введите имя новой заявки: ");
                String newName = scanner.nextLine();
                Item newItem = new Item(newName);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Замена прошла успешно, " + "Актуальная заявка: " + newItem);
                } else {
                    System.out.println("Введите корректный ID: ");
                }

            } else if (select == 3) {
                System.out.println("== Выберите заявку для удаления ==");
                int deleteId = Integer.parseInt(scanner.nextLine());
                boolean isValid = tracker.findById(deleteId) != null;
                if (isValid) {
                    tracker.delete(deleteId);
                    System.out.println("Заявка №: " + deleteId + "удалена успешно");
                } else {
                    System.out.println("Такой заявки не существует");
                }
            } else if (select == 4) {
                System.out.println("Введите id заявки для просмотра статуса: ");

            } else if (select == 5) {
                System.out.println("Введите название заявки для просмотра статуса: ");
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);

    }
}

