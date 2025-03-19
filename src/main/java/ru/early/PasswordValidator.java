package ru.early;

import static java.lang.Character.isWhitespace;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        if (!hasUpperCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!hasLowerCase(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!hasDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!hasSpecial(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (!notSimple(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

    private static boolean hasUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSpecial(String password) {
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && !isWhitespace(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean notSimple(String password) {
        for (String simple : FORBIDDEN) {
            if (password.toLowerCase().contains(simple)) {
                return false;
            }
        }
        return true;
    }
}
