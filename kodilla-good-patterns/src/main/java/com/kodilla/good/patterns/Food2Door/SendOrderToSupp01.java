package com.kodilla.good.patterns.Food2Door;

public class SendOrderToSupp01 implements SendOrdrToSuppleier {

    @Override
    public boolean sendOrder(){
        System.out.println("Order sent to supplier");
        return true;
    }
}
