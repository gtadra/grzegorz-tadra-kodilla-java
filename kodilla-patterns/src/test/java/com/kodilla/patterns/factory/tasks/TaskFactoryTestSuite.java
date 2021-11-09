package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

   @Test
   void testShoppingTask(){
       //Given
       TaskFactory taskFactory = new TaskFactory();
       //When
       Task shopping = taskFactory.createTask(TaskFactory.SHOPPING);
       //Then
       assertEquals("Shopping", shopping.getTaskName());
       assertEquals(false, shopping.isTaskExecuted());
   }

    @Test
    void testPaintingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task painting = taskFactory.createTask(TaskFactory.PAINTING);
        painting.executeTask();
        //Then
        assertEquals("Painting", painting.getTaskName());
        assertEquals(true, painting.isTaskExecuted());
    }

    @Test
    void testDrivingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task driving = taskFactory.createTask(TaskFactory.DRIVING);
        //Then
        assertEquals("Driving", driving.getTaskName());
        assertEquals(false, driving.isTaskExecuted());
    }

}
