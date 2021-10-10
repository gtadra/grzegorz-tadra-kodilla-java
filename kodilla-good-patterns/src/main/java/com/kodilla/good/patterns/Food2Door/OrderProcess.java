package com.kodilla.good.patterns.Food2Door;

public class OrderProcess {
    private Ordering placeOrder;
    private SendOrdrToSuppleier sendOrdrToSuppleier;

    public OrderProcess(final Ordering placeOrder, final SendOrdrToSuppleier sendOrdrToSuppleier) {
        this.placeOrder = placeOrder;
        this.sendOrdrToSuppleier = sendOrdrToSuppleier;
    }

    public void process(OrderRequest orderRequest){
        boolean orderPlaced = placeOrder.Order(orderRequest);

        if (orderPlaced){
            sendOrdrToSuppleier.sendOrder();
        }else {
            System.out.println("tray again");
        }

    }

}
