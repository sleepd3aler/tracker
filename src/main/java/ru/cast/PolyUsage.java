package ru.cast;

public class PolyUsage {
    public static void main(String[] args) {
        Animal cow = new Cow();
        Animal goose = new Goose();
        Animal dog = new Dog();
        Animal gPig = new GuineaPig();

        Animal[] animals = {cow, goose, dog, gPig};
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}

