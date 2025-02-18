package ru.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int indexofNull = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                indexofNull = i;
                break;
            }
        }
        return indexofNull;
    }
}
