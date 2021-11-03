package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void addTest(){
        //Given
        double result;
        //When
        result = calculator.add(4,4);
        //Then
        assertEquals(8,result);

    }

    @Test
    void subTest(){
        //Given
        double result;
        //When
        result = calculator.sub(4,4);
        //Then
        assertEquals(0,result);
    }

    @Test
    void mulTest(){
        //Given
        double result;
        //When
        result = calculator.mul(4,4);
        //Then
        assertEquals(16,result);
    }

    @Test
    void divTest(){
        //Given
        double result;
        //When
        result = calculator.div(4,4);
        //Then
        assertEquals(1,result);
    }

}
