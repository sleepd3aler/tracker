package ru.collection;
//
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private final Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        if (citizens.containsKey(citizen.getPassport())) {
            return false;
        }
        citizens.put(citizen.getPassport(), citizen);
        return true;
    }

    public Citizen get(String passport) {
        return citizens.getOrDefault(passport, null);
    }
}
