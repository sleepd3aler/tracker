package ru.encapsulation;

public class ATM {
    public static void main(String[] args) {
        Account account = new Account();
        account.addMoney(100);
        System.out.println(account.balance);
        account.addMoney(200);
        System.out.println(account.balance);
    }
}
