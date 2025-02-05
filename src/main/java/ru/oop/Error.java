package ru.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {

    }

    public void printInfo() {
        System.out.println("Активно: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error error = new Error(true, 404, "Not Found");
        error.printInfo();

        Error error2 = new Error(false, 0, "No Error");
        error2.printInfo();

        Error error3 = new Error(true, 500, "Internal Server Error");
        error3.printInfo();

        Error error4 = new Error();
        error4.printInfo();

    }
}
