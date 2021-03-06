package com.kodilla.hibernate.task;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TASKSLIST")
public class TaskLists {
    private int id;
    private String listName;
    private String description;
    private List<Task> tasks = new ArrayList<>();

    public TaskLists() {
    }

    public TaskLists(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }
    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }
    @OneToMany(
            targetEntity = Task.class,
            mappedBy = "taskList",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Task> getTasks() {
        return tasks;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
