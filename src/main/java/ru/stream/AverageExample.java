package ru.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import ru.stream.mapto.Person;

public class AverageExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        OptionalDouble average = people.stream()
                .mapToInt(Person::getAge)
                .average();
        double result = average.getAsDouble();
        System.out.println(result);

    }
}
