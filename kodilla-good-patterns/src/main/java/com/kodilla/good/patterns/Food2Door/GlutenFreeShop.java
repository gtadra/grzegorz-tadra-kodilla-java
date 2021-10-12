package com.kodilla.good.patterns.Food2Door;

public class GlutenFreeShop implements SendOrdrToSuppleier {

    @Override
    public boolean sendOrder(){
        System.out.println("Order sent to GlutenFreeShop");
        return true;
    }
}
