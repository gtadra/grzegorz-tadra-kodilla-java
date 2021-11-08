package com.kodilla.patterns.strategy;

public class Costumer {
    private final String name;
    protected BuyPredictor buyPredictor;

    public Costumer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String predict(){
        return buyPredictor.predictWhatToBuy();
    }

    public void setBuyingStrategy(BuyPredictor buyPredictor){
        this.buyPredictor = buyPredictor;
    }
}
