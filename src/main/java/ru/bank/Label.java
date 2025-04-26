package ru.bank;

import org.jetbrains.annotations.NotNull;

/**
 * Класс описывает метку, которая содержит имя и оценку
 * @param name - имя
 * @param score - счёт
 * Класс реализовывает интерфейс Comparable, что позволяет сравнивать метки по счёту
 */
public record Label(String name, double score) implements Comparable<Label> {
    /**
     * Метод для сравнения меток
     * @param o метка, для сравнения с текущей меткой
     * @return возвращает 0 если текущий счет одинаковый, отрицательное число - если счет меньше,
     * положительное число, если счет больше
     */
    @Override
    public int compareTo(@NotNull Label o) {
        return Double.compare(this.score, o.score);
    }
}
