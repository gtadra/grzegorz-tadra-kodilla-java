package com.kodilla.good.patterns.Food2Door;

public class OrderRequesrRetriver {

    public OrderRequest retrive(){
        Product product = new Product("Product 1", 2.22);
        Supplier supplier = new Supplier("Supplier1", product);

        return new OrderRequest(supplier,product,20);
    }
}
