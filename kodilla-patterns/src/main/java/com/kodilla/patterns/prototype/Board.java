package com.kodilla.patterns.prototype;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Board extends Prototype<Board> {

    private String name;
    private Set<TaskList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<TaskList> getLists() {
        return lists;
    }

    @Override
    public String toString(){
        String s = "Board [" + name + "]";
        for (TaskList list : lists){
            s= s + list.toString() + "\n";
        }
        return s;
    }

    public Board shallowCopy() throws CloneNotSupportedException{
        return super.clone();
    }

    public Board deepCopy() throws CloneNotSupportedException{
        Board clonedBoad = super.clone();
        clonedBoad.lists = new HashSet<>();
        for (TaskList theList: lists){
            TaskList clonedList = new TaskList(theList.getName());
            for (Task task : theList.getTasks()){
                clonedList.getTasks().add(task);
            }
            clonedBoad.getLists().add(clonedList);
        }
        return clonedBoad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(name, board.name) &&
                Objects.equals(lists, board.lists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lists);
    }
}