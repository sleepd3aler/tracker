package ru.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Выбрать: ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 0 -> {
                    System.out.println("Введите название заявки: ");
                    run = false;
                }
                case 1 -> {
                    System.out.println("Список заявок: ");
                    run = false;
                }
                case 2 -> {
                    System.out.println("Выберите заявку для изменения: ");
                    run = false;
                }
                case 3 -> {
                    System.out.println("Выберите заявку для удаления: ");
                    run = false;
                }
                case 4 -> {
                    System.out.println("Введите id заявки для просмотра статуса: ");
                    run = false;
                }
                case 5 -> {
                    System.out.println("Введите название заявки для просмотра статуса: ");
                    run = false;
                }
                case 6 -> {
                        System.out.println("Программа завершена!");
                        run = false;
                }
                default -> System.out.println("Выберите Пункт меню!");
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

