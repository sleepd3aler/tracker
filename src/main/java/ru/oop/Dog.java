package ru.oop;

public class Dog {

   private String food;

    public String sound() {
        String voice = "bark bark";
        return voice;
    }

    public static void main(String[] args) {
        Dog zhychka = new Dog();
        Dog polkan = new Dog();
        Dog sharik = new Dog();
        String say = zhychka.sound();
        System.out.println(say);
    }
}
