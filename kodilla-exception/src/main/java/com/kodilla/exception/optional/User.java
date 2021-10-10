package com.kodilla.exception.optional;

public class User {
    private String name;
    private int age;
    private int id;
    private  String lastName;


    public User(String name, int age, int id, String lastName) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.lastName = lastName;
    }

    public String getUserName() {
        return name;
    }
}
