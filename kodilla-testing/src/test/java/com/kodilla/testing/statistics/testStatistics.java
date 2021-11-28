package com.kodilla.testing.statistics;

import com.kodilla.testing.library.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class testStatistics {

    private List<String> generateListOfNUnerNames(int userQuantity){
        List<String> resultList = new ArrayList<>();
        for (int n=1; n <= userQuantity; n++){
            resultList.add("User " + n);
        }
        return resultList;
    }

    @Mock
    public Statistics statisticsMock;



    @Test
    void testPostNumberZero(){
        //Given
            CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
            List<String> userList = generateListOfNUnerNames(1000);
            int postsCount = 0;
            int commentsCount = 0;
            when(statisticsMock.usersNames()).thenReturn(userList);
            when(statisticsMock.postsCount()).thenReturn(postsCount);
            when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //When
            calculateStatistics.calculateAdvStatistics(statisticsMock);
            calculateStatistics.showStatistics();
        //Then
            assertEquals(1000,calculateStatistics.getUserQuantity());
            assertEquals(0,calculateStatistics.getPostsQuantity());
            assertEquals(0,calculateStatistics.getCommentsQuantity());
            assertEquals(0,calculateStatistics.getAvgPostsPerUser());
            assertEquals(0,calculateStatistics.getAvgCommentsPerUser());
            assertEquals(0,calculateStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testPostNumber1000(){
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> userList = generateListOfNUnerNames(100);
        int postsCount = 1000;
        int commentsCount = 0;
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();
        //Then
        assertEquals(100,calculateStatistics.getUserQuantity());
        assertEquals(1000,calculateStatistics.getPostsQuantity());
        assertEquals(0,calculateStatistics.getCommentsQuantity());
        assertEquals(10,calculateStatistics.getAvgPostsPerUser());
        assertEquals(0,calculateStatistics.getAvgCommentsPerUser());
        assertEquals(0,calculateStatistics.getAvgCommentsPerPost());
    }

    @Test
    void testMorePostsThenComments(){
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> userList = generateListOfNUnerNames(100);
        int postsCount = 1000;
        int commentsCount = 100;
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();
        //Then
        assertEquals(100,calculateStatistics.getUserQuantity());
        assertEquals(1000,calculateStatistics.getPostsQuantity());
        assertEquals(100,calculateStatistics.getCommentsQuantity());
        assertEquals(10,calculateStatistics.getAvgPostsPerUser());
        assertEquals(1,calculateStatistics.getAvgCommentsPerUser());
        assertEquals(0.1,calculateStatistics.getAvgCommentsPerPost());
    }
    @Test
    void testZeroUsers(){
        //Given
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> userList = generateListOfNUnerNames(0);
        int postsCount = 0;
        int commentsCount = 0;
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        calculateStatistics.showStatistics();
        //Then
        assertEquals(0,calculateStatistics.getUserQuantity());
        assertEquals(0,calculateStatistics.getPostsQuantity());
        assertEquals(0,calculateStatistics.getCommentsQuantity());
        assertEquals(0,calculateStatistics.getAvgPostsPerUser());
        assertEquals(0,calculateStatistics.getAvgCommentsPerUser());
        assertEquals(0,calculateStatistics.getAvgCommentsPerPost());
    }
}
