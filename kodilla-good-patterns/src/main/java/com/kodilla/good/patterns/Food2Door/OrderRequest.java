package com.kodilla.good.patterns.Food2Door;

public class OrderRequest {
    private Supplier supplier;
    private Product product;
    private double quantity;

    public OrderRequest(Supplier supplier, Product product, double quantity) {
        this.supplier = supplier;
        this.product = product;
        this.quantity = quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }
}
