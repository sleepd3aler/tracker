package ru.bank;

import java.util.Objects;

/**
 * Класс описывает объект банковского аккаунта пользователя.
 *
 * @author Alexander Novitskiy
 * @version 1.0
 */
public class Account {
    /**
     * Хранение реквизитов
     */
    private String requisite;
    /**
     * Хранение текущего баланса
     */
    private double balance;

    /**
     * Конструктор, с параметрами для создания объектов Account
     *
     * @param requisite - Реквизиты пользователя
     * @param balance   - Текущий баланс пользователя
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить текущие реквизиты Аккаунта
     *
     * @return - возвращает реквизиты
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет получить текущий баланс Аккаунта
     *
     * @return - возвращает баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет изменить текущее значение баланса Аккаунта
     *
     * @param balance - новое значение баланса
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод сравнивает Аккаунты по реквизитам
     *
     * @param o - объект с которым происходит сравнение
     * @return - возвращает true, если объекты одинаковые, false - если разные
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод сравнивает Аккаунты по хэш коду реквизитов
     *
     * @return - возвращает хэш код реквизитов
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(requisite);
    }
}
