package ru.search;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Ivanov", "534872", "Bryansk")
        );
        var persons = phones.find("Ivan");
        assertThat(persons.get(0).getSurname()).isEqualTo("Ivanov");
    }

    @Test
    public void whenNotFoundThenEmptyList() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Mariya", "Novitskaya", "458519", "Sevastopol")
        );
        var persons = phones.find("Simferopol");
        assertThat(persons).isEmpty();
    }

    @Test
    public void whenFindByNameWithFunction() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Petrov", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Petrov");
    }
}
