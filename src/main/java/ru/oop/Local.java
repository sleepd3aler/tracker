package ru.oop;

public class Local {
    private String name = "Petr";

    private void getFullName() {
        final String surname = "Ivanov";

       class FullName {
            public void printFullName() {
                System.out.println(name + " " + surname);
            }
        }

        FullName fullName = new FullName();
        fullName.printFullName();
    }

    public static void main(String[] args) {
        Local local = new Local();
        local.getFullName();

    }
}
