package ru.ex;

public class NPE {
    public static void main(String[] args) {
        String[] shops = new String[5];
        shops[0] = "Ivan Ivanov";
        for (int i = 0; i < shops.length; i++) {
            String element = shops[i];
            if (element != null) {
                System.out.println(element + "has a size of " + element.length());
            }
        }
    }
}