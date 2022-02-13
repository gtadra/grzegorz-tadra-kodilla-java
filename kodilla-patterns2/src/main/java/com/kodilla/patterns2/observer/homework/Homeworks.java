package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.homework.Observer;

import java.util.ArrayList;
import java.util.List;

public class Homeworks implements Observable{
    private final List<Observer> observers;
    private final List<String> homeworks;
    private final String studentName;

    public Homeworks(String studentName) {
        observers = new ArrayList<>();
        homeworks = new ArrayList<>();
        this.studentName = studentName;
    }

    public void addHomework(String homework) {
        homeworks.add(homework);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<String> getHomeworks() {
        return homeworks;
    }

    public String getStudentName() {
        return studentName;
    }
}
