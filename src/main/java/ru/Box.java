package ru;

public class Box {
    public static void main(String[] args) {
        int a = 2;
        int x = 2;
        Integer b;
        b = a;
        System.out.println("Integer b: " + b);
        num(x);
        num(b);
    }

    public static void num(Integer x) {
        System.out.println("Значение типа Integer: " + x);
    }

    public static void num(int x) {
        System.out.println("Значение типа int: " + x);
    }
}
