package ru.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = person -> person.getName().contains(key) || person.getSurname().contains(key)
                || person.getPhone().contains(key) || person.getAdress().contains(key);
        ArrayList<Person> result = new ArrayList<>();
        persons.forEach(person -> {
            if (combine.test(person)) {
                result.add(person);
            }
        });
        return result;
    }
}
