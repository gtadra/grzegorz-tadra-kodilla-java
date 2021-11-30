package com.kodilla.hibernate.task.dao;
import com.kodilla.hibernate.task.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TaskDao extends CrudRepository<Task,Integer> {
    List<Task>findByDuration(int duration);

    @Query
    List<Task> retrieveLongTasks();

    @Query
    List<Task> retrieveSortTask();

    @Query(nativeQuery = true)
    List<Task> retrieveTaskWithEnoughTime();

    @Query
    List<Task> retrieveTasksWithDurationLongerThen(@Param("DURATION") int duration);
}
