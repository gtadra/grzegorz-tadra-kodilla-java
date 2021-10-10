package com.kodilla.good.patterns.challenges;

public class ProductOrderService implements OrderServices{
    private User user;
    private Product product;

    @Override
    public boolean order(User user, Product product){
        System.out.println("User: " + user.getName() + " request to order: " + product.getProductName());
        return true;
    }


}
