package com.kodilla.good.patterns.challenges;

public class ProductOrderRepository implements OrderRepositories {

    @Override
    public void createOrder(User user, Product product){
        System.out.println("SAVED in DB");
    }
}
