package ru.ex;

public class UserStore {
    private static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User value : users) {
            if (login.equals(value.getUsername())) {
                user = value;
                break;
            }
        }
        if (user == null) throw new UserNotFoundException("User not found");
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        String login = user.getUsername();
        boolean valid = user.isValid() && login.length() > 3;;
        if (!valid) throw new UserInvalidException("User invalid");
        return valid;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Ivan Ivanov", true)
        };
        User user = null;
        try {
            user = findUser(users, "Ivan Ivanov");
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
           throw new RuntimeException(e);
        }
    }
}

