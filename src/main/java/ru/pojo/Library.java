package ru.pojo;

public class Library {
    public static void main(String[] args) {

        Book[] books = {new Book("Clean Code", 500), new Book("Dracula", 670),
                new Book("Tom Soyer", 700), new Book("Bartenders Bible", 350)};

        for (Book bks : books) {
            System.out.println("Book " + "\"" + bks.getName() + "\"" + " contains : "
                    + bks.getCount() + " pages");
        }
        System.out.println("Result after replacement");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book bks : books) {
            System.out.println("Book " + "\"" + bks.getName() + "\"" + " contains : " + bks.getCount() + " pages");
        }

        System.out.println("Show only Clean Code");
        for (Book bk : books) {
            if ("Clean Code".equals(bk.getName())) {
                System.out.println("Requested book " + "\"" + bk.getName() + "\"" + " has founded, and contains: "
                        + bk.getCount() + " pages");
            }
        }
    }
}


