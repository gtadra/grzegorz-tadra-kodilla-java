package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HomeworkTestSuite {

    @Test
    void testHomeworkObserver() {
        //Given
        Homeworks student1 = new Homeworks("Jan Kowalski");
        Homeworks student2 = new Homeworks("Ryszard Ziemny");
        Homeworks student3 = new Homeworks("Maciej Blady");
        Mentor mentor1 = new Mentor("Adrian");
        Mentor mentor2 = new Mentor("Maciej");
        student1.registerObserver(mentor1);
        student2.registerObserver(mentor1);
        student3.registerObserver(mentor2);
        //When
        student1.addHomework("Homework 1 for Student 1");
        student1.addHomework("Homework 2 for Student 1");
        student2.addHomework("Homework 1 for Student 2");
        student3.addHomework("Homework 1 for Student 3");
        student3.addHomework("Homework 2 for Student 3");
        //Then
        assertEquals(3,mentor1.getUpdateCount());
        assertEquals(2,mentor2.getUpdateCount());
    }
}
