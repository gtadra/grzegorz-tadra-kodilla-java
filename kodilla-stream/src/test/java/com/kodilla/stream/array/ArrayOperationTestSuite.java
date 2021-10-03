package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayOperationTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] intArray = {6, 6, 2, 2};
        ArrayOperationClass arrayOperations = new ArrayOperationClass();

        //When
        double result = arrayOperations.getAverageFn(intArray);

        //Then
        assertEquals(4.0, result);

    }
}
