package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TaskLists;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TaskListDao1 extends CrudRepository<TaskLists, Integer> {
}