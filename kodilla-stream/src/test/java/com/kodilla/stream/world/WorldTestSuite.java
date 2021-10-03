package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity(){
        //Given
        Country country1 = new Country(new BigDecimal("100000000001"));
        Country country2 = new Country(new BigDecimal("100000000001"));
        Country country3 = new Country(new BigDecimal("100000000001"));
        Country country4 = new Country(new BigDecimal("100000000001"));
        Country country5 = new Country(new BigDecimal("100000000001"));
        Country country6 = new Country(new BigDecimal("100000000001"));
        Country country7 = new Country(new BigDecimal("100000000001"));
        Continent continent1 = new Continent();
        Continent continent2 = new Continent();
        World world = new World();

        continent1.addCountry(country1);
        continent1.addCountry(country2);
        continent1.addCountry(country3);
        continent1.addCountry(country4);
        continent2.addCountry(country5);
        continent2.addCountry(country6);
        continent2.addCountry(country7);
        world.addContinent(continent1);
        world.addContinent(continent2);

        //When
        BigDecimal resultPeopleQuantity = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("700000000007");
        assertEquals(expectedPeopleQuantity,resultPeopleQuantity);
    }
}
