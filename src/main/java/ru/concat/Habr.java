package ru.concat;

public class Habr {
    public static void main(String[] args) {
        String habr = "habrahabr";
        int length = habr.length();
        char searchChar = 'h';
        boolean isFound = false;
        habr.indexOf(searchChar);
        System.out.println(message(habr.indexOf(searchChar) != -1));

    }

    private static String message(boolean b) {
        return "Your char had".concat(b ? " " : "n't").concat("been found!");
    }
}
