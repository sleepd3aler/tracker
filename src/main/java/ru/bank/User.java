package ru.bank;

import java.util.Objects;

/**
 * Класс описывает объекты пользователей банковского сервиса
 *
 * @author Alexander Novitskiy
 * @version 1.0
 */
public class User {
    /**
     * Хранение паспорта
     */
    private String passport;
    /**
     * Хранение имени пользователя
     */
    private String username;

    /**
     * Конструктор с параметрами для создания объектов User
     *
     * @param passport - Паспорт пользователя
     * @param username - Имя пользователя
     */

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод, возвращает информацию о паспорте пользователя
     * @return - возвращает информацию о паспорте польователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод, возвращает информацию о паспорте пользователя
     * @return - возвращает информацию о паспорте пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод, возвращает информацию об имени пользователя
     * @return - возвращает информацию об имени пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод, изменяет имя пользователя
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод сравнивает объект пользователя по паспорту
     * @param o - Объект пользователя
     * @return - возвращает true, если объекты одинаковые, false - если разные
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод сравнивает пользователй по хэш коду паспорта
     *
     * @return - возвращает хэш код паспорта
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(passport);
    }
}
