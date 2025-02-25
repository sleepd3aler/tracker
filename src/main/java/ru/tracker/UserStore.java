package ru.tracker;

public class UserStore {
    public static void main(String[] args) {
        User user = new User(1, "root", "root");
        String s = "Hello " + user;
        System.out.println(s);
    }
}
