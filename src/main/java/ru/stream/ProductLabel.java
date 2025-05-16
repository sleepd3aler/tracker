package ru.stream;

import java.util.ArrayList;
import java.util.List;

public class ProductLabel {

    public List<String> generateLabels(List<Product> products) {
        List<String> result = new ArrayList<>();
        products.stream()
                .filter(product -> {
                    int diff = product.getStandart() - product.getActual();
                    return diff >= 0 && diff <= 3;
                })
                .map(product -> new Label(product.getName(), product.getPrice() / 2))
                .map(Label::toString)
                .forEach(result::add);
        return result;

    }
}
