package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.TaskLists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TaskDaoTestSuite {

    @Autowired
    private TaskDao taskDao;
    private static final String DESCRIPTION = "Test: Lern Hibernate";
    @Autowired
    private TaskListDao1 taskListDao1;


    @Test
    void testTaskDaoSave(){
        //Given
        Task task = new Task(DESCRIPTION, 7);

        //When
        taskDao.save(task);

        //Then
        int id = task.getId();
        Optional<Task> readTask = taskDao.findById(id);
        assertTrue(readTask.isPresent());

        //CleanUp
        taskDao.deleteById(id);
    }

    @Test
    void testTaskDaoFindByDuration(){
        //Given
        Task task = new Task(DESCRIPTION, 7);
        taskDao.save(task);
        int duration = task.getDuration();

        //When
        List<Task> readTasks = taskDao.findByDuration(duration);

        //Then
        assertEquals(1,readTasks.size());

        //CleanUp
        int id = readTasks.get(0).getId();
        taskDao.deleteById(id);
    }

    @Test
    void testTaskDaoSaveWithFinancialDetails(){
        //Given
        Task task = new Task(DESCRIPTION, 30);
        task.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal(120), false));

        //When
        taskDao.save(task);
        int id = task.getId();

        //Then
        assertNotEquals(0,id);

        //CleanUp
        taskDao.deleteById(id);
    }

    @Test
    void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskLists taskLists = new TaskLists("LISTNAME", "ToDo tasks");
        taskLists.getTasks().add(task);
        taskLists.getTasks().add(task2);
        task.setTaskList(taskLists);
        task2.setTaskList(taskLists);

        //When
        taskListDao1.save(taskLists);
        int id = taskLists.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        //taskListDao.deleteById(id);
    }
}
