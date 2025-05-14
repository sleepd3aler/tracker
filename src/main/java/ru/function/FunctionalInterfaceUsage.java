package ru.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "New String For Interface";
        System.out.println(supplier.get());
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> setSupplier = () -> new HashSet<>(list);
        for (String s : setSupplier.get()) {
            System.out.println(s);
        }
        Consumer<String> consumer = (string) -> System.out.println(string);
        BiConsumer<Integer, String> biConsumer = (first, second) -> System.out.println(first + second);
        Set<String> strings = setSupplier.get();
        int i = 1;
        for (String s : strings) {
            biConsumer.accept(i++, " is " + s);
        }
        Predicate<String> predicate = string -> string.isEmpty();
        System.out.println("Строка пустая: " + predicate.test(""));
        System.out.println("Строка пустая: " + predicate.test("test"));

        BiPredicate<String, Integer> condition = (string, number) -> string.contains(number.toString());
        System.out.println("Строка содержит подстроку: " + condition.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + condition.test("Name", 123));

        Function<String, Character> function = string -> string.charAt(2);
        System.out.println("Третий символ в строке: " + function.apply("first"));
        System.out.println("Третий символ в строке: " + function.apply("second"));

        BiFunction<String, Integer, String> biFunction = (string, number) ->
                                            string.concat("").concat(number.toString());
        System.out.println("Результат работы бифункции: " + biFunction.apply("Name ", 123));
        System.out.println("Результат работы бифункции: " + biFunction.apply("String number ", 12345));

        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));

        BinaryOperator<StringBuilder> binaryBuilder = (first, second) ->
                                                        first.append(" ").append(second);
        System.out.println(
                "Строка после объединения: " + binaryBuilder.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );

        String[] names = {"Ivan"};
        Comparator<String> lengthComparator = (first, second) -> {
            System.out.println("execute comparator");
            return Integer.compare(first.length(), second.length());
        };
        Arrays.sort(names, lengthComparator);
        names = new String[]{"Ivan", "Bolvan"};
        Arrays.sort(names, lengthComparator);
    }
}
