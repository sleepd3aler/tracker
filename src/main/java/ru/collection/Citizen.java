package ru.collection;
//
import java.util.Objects;

public class Citizen {
    private String passport;
    private String username;

    public Citizen(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Citizen that = (Citizen) o;
        return Objects.equals(passport, that.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(passport);
    }
}
