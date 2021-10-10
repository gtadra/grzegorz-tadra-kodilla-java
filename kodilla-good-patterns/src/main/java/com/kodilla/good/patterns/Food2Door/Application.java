package com.kodilla.good.patterns.Food2Door;

public class Application {

    public static void main(String[] args){
        OrderRequesrRetriver orderRequesrRetriver = new OrderRequesrRetriver();
        OrderRequest orderRequest = orderRequesrRetriver.retrive();

        OrderProcess orderProcess = new OrderProcess(new PlaceInternalOrder(), new SendOrderToSupp01());
        orderProcess.process(orderRequest);
    }
}
