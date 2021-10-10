package com.kodilla.exception.optional;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args){
        User user = new User(null,0,100,null);
        Optional<User> optionalUser = Optional.ofNullable(user);

        String username =
                optionalUser.orElse(new User("XX",0,0,"XXX")).getUserName();

        System.out.println(username);
    }
}
