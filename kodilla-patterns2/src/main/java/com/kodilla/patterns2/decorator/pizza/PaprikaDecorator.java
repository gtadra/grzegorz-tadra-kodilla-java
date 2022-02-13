package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PaprikaDecorator extends AbstractPizzaOrderDecorator{
    public PaprikaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(2.0));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", papryka";
    }
}
