package ru.pojo;

public class Library {
    public static void main(String[] args) {
        Book book = new Book("Clean Code", 500);
        Book book2 = new Book("Dracula", 670);
        Book book3 = new Book("Tom Soyer", 700);
        Book book4 = new Book("Bartenders Bible", 350);

        Book[] books = new Book[4];
        books[0] = book;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

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
            if (bk.getName().equals("Clean Code")) {
                System.out.println("Requested book " + "\"" + bk.getName() + "\"" + " has founded, and contains: "
                        + bk.getCount() + " pages");
            }
        }
    }
}


