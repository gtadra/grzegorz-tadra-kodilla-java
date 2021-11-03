package com.kodilla.spring.portofolio;

public class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void addToDo(String task){
        toDoList.addTask(task);
    }

    public void addInProgress(String task){
        inProgressList.addTask(task);
    }

    public void addDone(String task){
        doneList.addTask(task);
    }

}
