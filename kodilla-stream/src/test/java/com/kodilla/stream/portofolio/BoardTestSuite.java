package com.kodilla.stream.portofolio;

import com.kodilla.stream.portfolio.Board;
import com.kodilla.stream.portfolio.Task;
import com.kodilla.stream.portfolio.TaskList;
import com.kodilla.stream.portfolio.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class BoardTestSuite {

    @Test
    void testAddTaskList(){
    //Given
    Board project = prepareTestData();
    //When

    //Then
    assertEquals(3, project.getTaskLists().size());

}

    @Test
    void testAddTaskListFindUsersTask(){
        //Given
        Board project = prepareTestData();
        //When
        User user1 = new User("developer1", "John Smith");
         List<Task> tasks = project.getTaskLists().stream()
                .flatMap(f -> f.getTasks().stream())
                .filter(l -> l.getAssignedUser().equals(user1))
                 .collect(Collectors.toList());
        //Then
        assertEquals(2,tasks.size());
        assertEquals(user1, tasks.get(0).getAssignedUser());
        assertEquals(user1, tasks.get(1).getAssignedUser());

    }

    @Test
    void testAddTaskListFindOutdatedTasks(){
        //Given
        Board project = prepareTestData();
        //When
        List<Task> tasks = project.getTaskLists().stream()
                .filter(k -> (k.getName().equals("In progress") || k.getName().equals("To Do")))
                .flatMap(f -> f.getTasks().stream())
                .filter(l -> l.getDeadline().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
        //Then
        assertEquals(1, tasks.size());
        assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }

    @Test
    void testAddTaskListFindLongTasks(){
        //Given
        Board project = prepareTestData();
        //When
        long longTasks = project.getTaskLists().stream()
                .filter(k -> k.getName().equals("In progress"))
                .flatMap(f -> f.getTasks().stream())
                .map(Task::getCreated)
                .filter(l -> l.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();
        //Then
        assertEquals(2, longTasks);
    }

    @Test
    void testAddTaskListAverageWorkingOnTask(){
        //Given
        Board project = prepareTestData();
        //When
        List<Long> listOfDays =
                project.getTaskLists().stream()
                .filter(k -> k.getName().equals("In progress"))
                .flatMap(f -> f.getTasks().stream())
                .map(l -> Duration.between(LocalDate.now().atStartOfDay(), l.getCreated().atStartOfDay()).toDays())
                        .collect(Collectors.toList());

        Double avgDaysForTask = Math.abs(IntStream.range(0,listOfDays.size())
                .mapToDouble(n -> listOfDays.get(n))
                .average().getAsDouble());

        assertEquals(10, avgDaysForTask);
    }


    private Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));

        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }
}
