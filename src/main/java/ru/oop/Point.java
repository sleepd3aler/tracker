package ru.oop;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Point {

    private int x;

    private int y;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(Point another) {
        return sqrt(pow(this.x - another.x, 2) + pow(this.y - another.y, 2));
    }

}
