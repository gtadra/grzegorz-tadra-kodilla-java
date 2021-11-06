package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    @Test
    void getLastLogTest() {
        //Given
        Logger logger = Logger.INSTANCE;
        logger.log("new log");
        //When
        String lastLog = logger.getLastLog();
        //Then
        assertEquals("new log",lastLog);
    }
}
