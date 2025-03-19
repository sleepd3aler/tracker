package ru.early;

import static java.lang.Character.*;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        char[] chars = password.toCharArray();
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        boolean simple = false;
        for (char aChar : chars) {
            if (isUpperCase(aChar)) {
                hasUpperCase = true;
            }
            if (isLowerCase(aChar)) {
                hasLowerCase = true;
            }
            if (isDigit(aChar)) {
                hasDigit = true;
            }
            if (!isLetterOrDigit(aChar) && !isWhitespace(aChar)) {
                hasSpecial = true;
            }
        }
        for (String simple2 : FORBIDDEN) {
            if (password.toLowerCase().contains(simple2)) {
                simple = true;
                break;
            }
        }
        if (!hasUpperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!hasLowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!hasDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (simple) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }

        return password;
    }
}
