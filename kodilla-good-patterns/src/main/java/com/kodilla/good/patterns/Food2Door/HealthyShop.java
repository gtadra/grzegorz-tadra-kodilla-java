package com.kodilla.good.patterns.Food2Door;

public class HealthyShop implements SendOrdrToSuppleier {

    @Override
    public boolean sendOrder(){
        System.out.println("Order sent to HealthyShop");
        return true;
    }
}
