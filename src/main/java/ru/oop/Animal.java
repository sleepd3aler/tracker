package ru.oop;

/**
 * Это программа зоопарк - у нас есть абстрактный класс, который будет являтся шаблоном для будущих классов(животных)
 * у этого класса есть параметры:
 * Имя
 * Возраст и вес
 */
public abstract class Animal {
    private String name;
    private int age;
    private double weight;

    public Animal() {
    }

    /**
     * Геттеры
     * @return
     */
    public String getName() {
       return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract void makeSound();

    public void eat() {
        System.out.println("Я ем");
    }
}
