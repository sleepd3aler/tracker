package ru.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                result = i;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Такого элемента не существует");
        }
        return result;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        String[] elements = {"Cat", "Dog", "Pig"};
        try {
            indexOf(elements, "kitty");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
