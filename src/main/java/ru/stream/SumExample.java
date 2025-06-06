package ru.stream;

import java.util.Arrays;
import java.util.List;
import ru.stream.mapto.Person;

public class SumExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int sum = people.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println(sum);

    }
}
