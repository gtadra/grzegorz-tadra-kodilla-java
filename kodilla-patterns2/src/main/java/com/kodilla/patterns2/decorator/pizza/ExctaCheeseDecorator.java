package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExctaCheeseDecorator extends AbstractPizzaOrderDecorator{
    public ExctaCheeseDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(5.0));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + dodatkowy ser";
    }
}
