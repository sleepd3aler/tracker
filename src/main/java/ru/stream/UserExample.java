package ru.stream;

public class UserExample {
    private String name;
    private String surname;
    private byte age;
    private String login;
    private String password;
    private boolean activated;
    private String gender;

    static class Builder {

        private String name;
        private String surname;
        private byte age;
        private String login;
        private String password;
        private boolean activated;
        private String gender;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildLogin(String login) {
            this.login = login;
            return this;
        }

        Builder buildPassword(String password) {
            this.password = password;
            return this;
        }

        Builder buildActivated(boolean activated) {
            this.activated = activated;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        UserExample build() {
            UserExample userExample = new UserExample();
            userExample.name = name;
            userExample.surname = surname;
            userExample.age = age;
            userExample.login = login;
            userExample.password = password;
            userExample.activated = activated;
            userExample.gender = gender;
            return userExample;
        }

    }

    @Override
    public String toString() {
        return "UserExample{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", activated=" + activated +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static void main(String[] args) {
        UserExample userExample = new Builder().buildName("name")
                .buildSurname("surname")
                .buildAge((byte) 32)
                .buildLogin("login")
                .buildPassword("password")
                .buildActivated(true)
                .buildGender("male")
                .build();
        System.out.println(userExample);
    }
}

