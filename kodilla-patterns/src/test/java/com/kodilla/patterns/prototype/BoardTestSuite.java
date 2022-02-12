package com.kodilla.patterns.prototype;

import com.kodilla.patterns.prototype.Board;
import com.kodilla.patterns.prototype.Task;
import com.kodilla.patterns.prototype.TaskList;
import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTestSuite {

    @Test
    void testToString(){
        //Given
        // task list fo todos
        TaskList listToDo = new TaskList("To Do Tasks");
        IntStream.iterate(1,n->n+1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task number " + n)));
        //task list in progress
        TaskList listInProgress = new TaskList("In Prograss Tasks");
        IntStream.iterate(1, n->n+1)
                .limit(10)
                .forEach(n->listInProgress.getTasks().add(new Task("In Progress Task number " + n)));
        //task lists for done tasks
        TaskList listDone = new TaskList("Done Tasks");
        IntStream.iterate(1,n->n+1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done task number " + n)));
        //Creating Board & assigning tasks
        Board board = new Board("Project nuber 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        //shallow copy
        Board clonedBoard = null;
        try{
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //deep copy
        Board deepClonedBoard = null;
        try{
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Project number 3");
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //When
        //NEW: removing elements
        board.getLists().remove(listToDo);

        System.out.println(board);
        System.out.println(clonedBoard);

        //Then

        //CHANGED
        assertEquals(2, board.getLists().size());
        assertEquals(2, clonedBoard.getLists().size());
        assertEquals(3, deepClonedBoard.getLists().size());
        assertEquals(clonedBoard.getLists(), board.getLists());
        assertNotEquals(deepClonedBoard.getLists(), board.getLists());
    }
}
