package com.kodilla.spring.portofolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.addToDo("zadanie to do");
        board.addToDo("zadanie to do1");
        board.addInProgress("zadanie in progress");
        board.addDone("zadanie done");

        List<String> resultAddToDo = board.getToDoList().getTasks();
        List<String> resultAddInProgress = board.getInProgressList().getTasks();
        List<String> resultAddDone = board.getDoneList().getTasks();
        //Then
        assertEquals("zadanie to do1", resultAddToDo.get(1));
        assertEquals("zadanie in progress", resultAddInProgress.get(0));
        assertEquals("zadanie done", resultAddDone.get(0));



    }

}
