package ru.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до " + count);
            int matches = Integer.parseInt(input.nextLine());
            turn = !turn;
            if (matches <= count) {
                switch (matches) {
                    case 1, 2, 3 -> count -= matches;
                    default -> {
                        turn = !turn;
                        System.out.println("Введите число от 1 до 3!");
                    }
                }
            } else {
                turn = !turn;
                System.out.println("Введите правильное число!");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}


