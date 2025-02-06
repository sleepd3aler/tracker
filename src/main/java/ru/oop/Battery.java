package ru.oop;

public class Battery {

    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public String about() {
        return "My charge: " + load + "%";
    }

    public void exchange(Battery another) {
       another.load = another.load + this.load;
       this.load = 0;

    }

    public static void main(String[] args) {
        Battery first = new Battery(80);
        Battery second = new Battery(20);
        first.exchange(second);
        System.out.println("First." + first.about());
        System.out.println("Second." + second.about());
    }
}
