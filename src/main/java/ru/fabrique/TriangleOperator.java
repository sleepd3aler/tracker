package ru.fabrique;

import java.util.Scanner;

public class TriangleOperator extends ShapeOperator {
     private Scanner input = new Scanner(System.in);

    @Override
    public Shape createShape() {
        System.out.println("Введите длину основания треугольника: ");
        int a = input.nextInt();
        System.out.println("Введите высоту треугольника: ");
        int b = input.nextInt();
        return new Triangle(a, b);
    }
}
