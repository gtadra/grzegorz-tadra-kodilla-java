package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName(){
        //Given
        TaskList taskList = new TaskList("List01", "Desc 01" );
        //When
        taskListDao.save(taskList);
        //Then
        List<TaskList> readTaskList = taskListDao.findByListName("List01");
        assertEquals(1, readTaskList.size());

        //CleanUp
        int id = readTaskList.get(0).getId();
        taskListDao.deleteById(id);
    }
}
