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

        char[] checkPass = password.toCharArray();
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (char checkSymbol : checkPass) {
            if (isUpperCase(checkSymbol)) {
                hasUpperCase = true;
                continue;
            }
            if (isLowerCase(checkSymbol)) {
                hasLowerCase = true;
                continue;
            }
            if (isDigit(checkSymbol)) {
                hasDigit = true;
                continue;
            }
            if (!isLetterOrDigit(checkSymbol) && !isWhitespace(checkSymbol)) {
                hasSpecial = true;
                break;
            }
        }
        for (String simple2 : FORBIDDEN) {
            if (password.toLowerCase().contains(simple2)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
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

        return password;
    }
}
