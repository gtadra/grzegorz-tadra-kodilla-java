package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void testprobablyIWillThrowException(){
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //Then & When
        assertAll(
                () -> assertThrows(Exception.class,() -> secondChallenge.probablyIWillThrowException(2,1)),
                () -> assertThrows(Exception.class,() -> secondChallenge.probablyIWillThrowException(1,1.5)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1,1))
        );
    }
}
