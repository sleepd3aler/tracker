package ru.fabrique;

import java.util.Scanner;

public class RectangleOperator extends ShapeOperator {
    private Scanner input = new Scanner(System.in);

    @Override
    public Shape createShape() {
        System.out.println("Введите ширину прямоугольника: ");
        int a = input.nextInt();
        System.out.println("Введите длину прямоугольника: ");
        int b = input.nextInt();
        return new Rectangle(a, b);
    }
}
