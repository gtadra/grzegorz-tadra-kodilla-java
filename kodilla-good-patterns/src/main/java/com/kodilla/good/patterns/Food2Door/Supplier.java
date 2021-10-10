package com.kodilla.good.patterns.Food2Door;

public class Supplier {
    private String name;
    private String shortName;
    private Product product;

    public Supplier(String name,Product product ) {
        this.name = name;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public Product getProduct() {
        return product;
    }
}
