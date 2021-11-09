package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.Shape;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task createTask(final String taskClass){
        switch (taskClass){
            case SHOPPING:
                return new ShoppingTask("Shopping", "Shoes", 1);
            case PAINTING:
                return new PaintingTask("Painting", "Red", "Wall");
            case DRIVING:
                return new DrivingTask("Driving", "Berlin", "Car");
            default:
                return null;
        }
    }

}
