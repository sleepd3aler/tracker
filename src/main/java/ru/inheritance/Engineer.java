package ru.inheritance;

public class Engineer extends Profession {

    private int experience;

    public Engineer(int experience, boolean degree) {
        super(degree);
        this.experience = experience;
    }

    public static void test() {
        System.out.println("сокрытие");
    }
}
