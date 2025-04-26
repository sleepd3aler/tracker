package ru.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @Test
    void whenException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Factorial().calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("Число должно быть положительным");
    }

    @Test
    void whenNoException() {
        int number = 5;
        int expected = 120;
        assertThat(new Factorial().calc(number)).isEqualTo(expected);
    }
}