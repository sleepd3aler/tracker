package ru.bank;

import org.jetbrains.annotations.NotNull;

public record Label(String name, double score) implements Comparable<Label> {
    @Override
    public int compareTo(@NotNull Label o) {
        return Double.compare(this.score, o.score);
    }
}
