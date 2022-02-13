package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.taxiportal.BasicTaxiOrder;
import com.kodilla.patterns2.decorator.taxiportal.TaxiOrder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderDecorator() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        BigDecimal calculatedCost = theOrder.getPrice();
        String description = theOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(15), calculatedCost);
        assertEquals("Pizza: sos pomidorowy, ser", description);
    }

    @Test
    public void testBasicPizzaAllDecorators() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HamDecorator(theOrder);
        theOrder = new PaprikaDecorator(theOrder);
        theOrder = new TomatoDecorator(theOrder);
        theOrder = new ExctaCheeseDecorator(theOrder);

        // When
        BigDecimal calculatedCost = theOrder.getPrice();
        String description = theOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(26), calculatedCost);
        assertEquals("Pizza: sos pomidorowy, ser, szynka, papryka, pomidory + dodatkowy ser", description);
    }

}
