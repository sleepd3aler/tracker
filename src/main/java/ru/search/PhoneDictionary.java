package ru.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            boolean isFound = person.getName().contains(key) || person.getSurname().contains(key)
                          || person.getPhone().contains(key) || person.getAdress().contains(key);
            if (isFound) {
                result.add(person);
            }
        }
        return result;
    }
}
