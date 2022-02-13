package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(Homeworks homeworks) {
        System.out.println(mentorName + ": New homework from " + homeworks.getStudentName() + "\n" +
                " (total: " + homeworks.getHomeworks().size() + " messages)");
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}