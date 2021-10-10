package com.kodilla.good.patterns.Food2Door;

public class PlaceInternalOrder implements Ordering{

    @Override
    public boolean Order(OrderRequest orderRequest) {
        if(orderRequest.getSupplier().getProduct().equals(orderRequest.getProduct())){
            System.out.println("Request: order " + orderRequest.getQuantity() + " of " + orderRequest.getProduct().getName() + " by " + orderRequest.getSupplier().getName());
            return true;
        } else{
            System.out.println(orderRequest.getProduct().getName() + " not available by " + orderRequest.getSupplier().getName());
            return false;
        }
    }
}
