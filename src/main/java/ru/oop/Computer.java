package ru.oop;

public class Computer {
    //Задаём поля - параметры обьекта
    private boolean multiMonitor;
    private int ssd;
    private String cpu;

    // создаём обьект класса компьютер (конструктор)
    public Computer(boolean multiMonitor, int ssd, String cpu) {
        this.multiMonitor = multiMonitor;
        this.ssd = ssd;
        this.cpu = cpu;

    }

    public Computer(int ssd, String cpu) {
        this.ssd = ssd;
        this.cpu = cpu;
    }

    public Computer(boolean multiMonitor, double ssd, String cpu) {
        this.multiMonitor = multiMonitor;
        this.ssd = (int) ssd;
        this.cpu = cpu;
    }

    public Computer() {

    }

    //создаем метод который выводит на печать инфо о ПК
    public void printInfo() {
        System.out.println("Много мониторов: " + multiMonitor);
        System.out.println("SSD: " + ssd + " Гб");
        System.out.println("Модель CPU: " + cpu);
        System.out.println();
    }

    //Главный метод который создаёт обьект класса компьютер
    public static void main(String[] args) {
        Computer computer = new Computer(true, 256, "M1"); // тут мы передаём значения переменных
        computer.printInfo(); // вызывает метод принт инфо, класса компьютер

        Computer secondComputer = new Computer();
        secondComputer.printInfo();

        Computer thirdComputer = new Computer(256, "M4");
        thirdComputer.printInfo();

        Computer fourthComputer = new Computer(true, 512.0, "Intel i7");
        fourthComputer.printInfo();
    }

}
