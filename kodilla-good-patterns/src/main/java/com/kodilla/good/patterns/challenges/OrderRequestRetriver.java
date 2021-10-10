package com.kodilla.good.patterns.challenges;

public class OrderRequestRetriver {

    public OrderRequest retrive(){
        User user = new User("user1");
        Product product = new Product("Product 1");

        return new OrderRequest(user,product);

    }
}
