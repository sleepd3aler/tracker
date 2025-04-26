package ru.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

public class PointTest {

    @Test
    void when00to20then2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double result = a.distance(b);
        double expected = 2;
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when00toMinus50then5() {
        Point a = new Point(0, 0);
        Point b = new Point(-5, 0);
        double result = a.distance(b);
        double expected = 5;
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when22to22then0() {
        Point a = new Point(2, 2);
        Point b = new Point(2, 2);
        double result = a.distance(b);
        double expected = 0;
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when10to00Then1() {
        Point a = new Point(1, 0);
        Point b = new Point(0, 0);
        double result = a.distance(b);
        double expected = 1;
        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void whenA02toC03Then1andB04toCThen1() {
        Point a = new Point(0, 2);
        Point b = new Point(0, 4);
        Point c = new Point(0, 3);
        double ac = a.distance3d(c);
        double acExpected = 1;
        double bc = b.distance3d(c);
        double bcExpected = 1;
        assertThat(ac).isEqualTo(acExpected, withPrecision(0.01));
        assertThat(bc).isEqualTo(bcExpected, withPrecision(0.01));
        assertThat(ac).isEqualTo(bc, withPrecision(0.01));
    }
}
