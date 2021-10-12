package com.kodilla.good.patterns.Food2Door;

public class ExtraFoodShop implements SendOrdrToSuppleier {

    @Override
    public boolean sendOrder(){
        System.out.println("Order sent to ExtraFoodShop");
        return true;
    }
}
