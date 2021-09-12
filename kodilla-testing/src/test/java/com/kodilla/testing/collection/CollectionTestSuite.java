package com.kodilla.testing.collection;

import com.kodilla.testing.collection.*;
import org.junit.jupiter.api.*;
import java.util.*;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void before(){
        System.out.println("Test Case: Start");
    }

    @AfterEach
    public void after(){
        System.out.println("Test Case: End");
    }

    @DisplayName("OddNumbersExtermination - reaction on empty List")
    @Test
void  testOddNumbersExterminatorEmptyList(){
        // Given
        List<Integer> testNumbers = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        result = oddNumbersExterminator.exterminate(testNumbers);
        //Then
        Assertions.assertTrue(result.isEmpty());
    }

    @DisplayName("OddNumbersExtermination functionality test")
    @Test
void testOddNumbersExterminatorNormalList(){
        // Given
        List<Integer> testNumbers = Arrays.asList(1,2,5,6,8,11,10);
        List<Integer> expectedResult = Arrays.asList(2,6,8,10);
        List<Integer> result = new ArrayList<>();
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        // When
        result = oddNumbersExterminator.exterminate(testNumbers);
        //Then
        Assertions.assertTrue(expectedResult.equals(result));

    }





}
