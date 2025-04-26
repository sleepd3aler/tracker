package ru.oop;
// Создаём класс Тамагочи
public class Tamagotchi {
// Создаем характеристики для обьектов Класса Тамагочи
    private int weight; //это поле равно 0, т.к. не инициализированно

//Создаём метод "кормить", который увеличивает "вес" на 10, после кормёжки
    public void feed() {
        weight += 10;
    }

//Создаём метод который будет возвращать Строку - инфо о нашем обьекте
    public String info() {
        return "weight: " + weight;
    }

    public static void main(String[] args) {
        Tamagotchi pet = new Tamagotchi();
        Tamagotchi petCopy = pet;
        System.out.println("weight: " + pet.info());
        System.out.println("copy of weight: " + petCopy.info());
        petCopy.feed();
        System.out.println("weight: " + pet.info());
        System.out.println("copy of weight: " + petCopy.info());
    }
}
