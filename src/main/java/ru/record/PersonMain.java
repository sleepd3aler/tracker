package ru.record;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Ivan", 30);
        System.out.println("Имя: " + person.getName() + ", Возраст: " + person.getAge());
        System.out.println(person);
        PersonRecord record = new PersonRecord("Ivan", 30);
        System.out.println("Имя: " + record.name() + ", Возраст: " + record.age());
        System.out.println(record);
        PersonRecord record1 = new PersonRecord("Ivan", 30);
        System.out.println(record.equals(record1));
    }
}
