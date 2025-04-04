package ru.pojo;

public class Store {
    public static void main(String[] args) {
        Product milk = new Product("Milk", 10);
        Product bread = new Product("Bread", 4);
        Product eggs = new Product("Eggs", 19);

        Product[] prods = new Product[5];
        prods[0] = milk;
        prods[1] = bread;
        prods[2] = eggs;

        for (int index = 0; index < prods.length; index++) {
            Product pr = prods[index];
            System.out.println(pr.getName() + " - " + pr.getCount());
        }

        System.out.println("Replace milk to oil");
        Product oil = new Product("Oil", 11);
        prods[0] = oil;
        for (int index = 0; index < prods.length; index++) {
            Product pr = prods[index];
            System.out.println(pr.getName() + " - " + pr.getCount());
        }
        System.out.println("Show only product.count > 10");
        for (int index = 0; index < prods.length; index++) {
            Product pr = prods[index];
            if (pr.getCount() > 10) {
                System.out.println(pr.getName() + " - " + pr.getCount());
            }
        }

        for (int index = 0; index < prods.length; index++) {
            Product product = prods[index];
            if (product != null) {
                System.out.println(product.getName());
            }
        }
    }
}
