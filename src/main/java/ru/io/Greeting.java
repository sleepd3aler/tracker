package ru.io;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Добро пожаловать. Как вас зовут?");
        String name = input.nextLine();
        System.out.println(name + ", Рад вас видеть!");
    }
}
