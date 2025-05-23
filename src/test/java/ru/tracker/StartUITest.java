package ru.tracker;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import ru.tracker.action.*;
import ru.tracker.input.Input;
import ru.tracker.input.MockInput;
import ru.tracker.output.MockOutput;
import ru.tracker.output.Output;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenCreateItem() {
        Output output = new MockOutput();
        Input input = new MockInput(List.of("0", "Item name", "1"));
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Create(output));
        actions.add(new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new MockOutput();
        Input input = new MockInput(List.of("0", "1", "Replaced name", "1"));
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new Replace(output), new Exit(output));
        tracker.add(new Item("Item name"));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Replaced name");
    }

    @Test
    void whenReplaceItemIsFailed() {
        Output output = new MockOutput();
        Input input = new MockInput(
                List.of("0", "2", "Replaced name", "1")
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new Replace(output), new Exit(output));
        tracker.add(new Item("Item name"));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isNotEqualTo("Replaced name");
    }

    @Test
    void whenDeleteItem() {
        Output output = new MockOutput();
        Input input = new MockInput(
                List.of("0", "1", "1")
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new Delete(output), new Exit(output));
        tracker.add(new Item("Item name"));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().size()).isZero();
    }

    @Test
    void whenDeleteItemIsFailed() {
        Input input = new MockInput(
                List.of("0", "2", "1")
        );
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new Delete(output), new Exit(output));
        tracker.add(new Item("Item name"));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().size()).isNotZero();
    }

    @Test
    void whenExit() {
        Output output = new MockOutput();
        Input input = new MockInput(
                List.of("0")
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(
                List.of("0", String.valueOf(one.getId()), replaceName, "1")
        );
        List<UserAction> actions = List.of(new Replace(output), new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Редактирование заявки ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenReplaceItemTestOutputIsFailed() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        String id = "3";
        String replaceName = "New Test";
        Input input = new MockInput(
                List.of("0", id, replaceName, "1")
        );
        List<UserAction> actions = List.of(new Replace(output), new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Редактирование заявки ===" + ln
                        + "Введен не существующий ID" + ln
                        + "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindAllItemsTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Input input = new MockInput(
                List.of("0", "1")
        );
        List<UserAction> actions = List.of(new FindAll(output), new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод всех заявок ===" + ln
                        + one + ln + two + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindAllItemsTestOutputIsFailed() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Input input = new MockInput(
                List.of("0", "1")
        );
        List<UserAction> actions = List.of(new FindAll(output), new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод всех заявок ===" + ln
                        + "Хранилище еще не содержит заявок" + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindItemsByIdTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        String findId = String.valueOf(one.getId());
        Input input = new MockInput(
                List.of("0", findId, "1")
        );
        List<UserAction> actions = List.of(new FindById(output), new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Просмотр заявки ===" + ln
                        + one + ln
                        + "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindItemsByIdTestOutputIsFailed() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        String findId = "3";
        Input input = new MockInput(
                List.of("0", findId, "1")
        );
        List<UserAction> actions = List.of(new FindById(output), new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Просмотр заявки ===" + ln
                        + "Такой заявки не существует" + ln
                        + "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindItemsByNameTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test1"));
        String findName = one.getName();
        Input input = new MockInput(
                List.of("0", findName, "1")
        );
        List<UserAction> actions = List.of(new FindByName(output), new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Просмотр заявок ===" + ln
                        + one + ln + two + ln
                        + "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindItemsByNameTestOutputIsFailed() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        String findName = "Failure";
        Input input = new MockInput(
                List.of("0", findName, "1")
        );
        List<UserAction> actions = List.of(new FindByName(output), new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Просмотр заявок ===" + ln
                        + "Заявки не найдены" + ln
                        + "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenInvalidExit() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Input input = new MockInput(
                List.of("2", "0")
        );
        List<UserAction> actions = List.of(new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "Неверный ввод, вы можете выбрать: 0 .. 0" + ln
                        + "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenCreateThenDeleteThenDeleteIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Input input = new MockInput(
                List.of("0", "Test", "1", "1", "1", "1", "2")
        );
        List<UserAction> actions = List.of(new Create(output), new Delete(output), new Exit(output));
        new StartUI(output).init(input, tracker, actions);
        Item item = tracker.add(new Item("Test"));
        item.setId(1);
        String test = item.toString();
        tracker.delete(item.getId());
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Добавить новую заявку" + ln
                        + "1. Удалить заявку" + ln
                        + "2. Завершить программу" + ln
                        + "== Создание новой заявки ==" + ln
                        + "Добавлена заявка: " + test + ln
                        + "Меню:" + ln
                        + "0. Добавить новую заявку" + ln
                        + "1. Удалить заявку" + ln
                        + "2. Завершить программу" + ln
                        + "== Удаление заявки ==" + ln
                        + "Заявка №: 1 удалена успешно" + ln
                        + "Меню:" + ln
                        + "0. Добавить новую заявку" + ln
                        + "1. Удалить заявку" + ln
                        + "2. Завершить программу" + ln
                        + "== Удаление заявки ==" + ln
                        + "Такой заявки не существует" + ln
                        + "Меню:" + ln
                        + "0. Добавить новую заявку" + ln
                        + "1. Удалить заявку" + ln
                        + "2. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln);
    }
}