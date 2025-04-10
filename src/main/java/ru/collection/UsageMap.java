package ru.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("qwerty@yandex.ru", "Ivan Ivanov");
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

    }
}
