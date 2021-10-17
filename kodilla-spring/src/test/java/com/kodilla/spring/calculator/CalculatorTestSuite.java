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
        //When
        calculator.add(4,4);
        //Then
    }

    @Test
    void subTest(){
        //Given
        //When
        calculator.sub(4,4);
        //Then
    }

    @Test
    void mulTest(){
        //Given
        //When
        calculator.mul(4,4);
        //Then
    }

    @Test
    void divTest(){
        //Given
        //When
        calculator.div(4,4);
        //Then
    }

}
