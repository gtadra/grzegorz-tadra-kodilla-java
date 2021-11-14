package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.Bigmac.BigMac;
import com.kodilla.patterns.builder.Bigmac.Ingredient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testNeBigMac() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun("Test")
                .burgers(2)
                .sauce("1000 islands")
                .ingredient(new Ingredient(Ingredient.BECKON))
                .ingredient(new Ingredient(Ingredient.CHEESE))
                .ingredient(new Ingredient(Ingredient.CHILLI))
                .build();

        //When
        //Then
        assertEquals(3,bigMac.getIngredients().size());
        assertEquals("Test",bigMac.getBun());
        assertEquals(2,bigMac.getBurgers());
        assertEquals("1000 islands",bigMac.getSauce());
    }
}
