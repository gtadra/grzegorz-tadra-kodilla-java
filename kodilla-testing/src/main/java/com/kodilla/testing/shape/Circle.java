package com.kodilla.testing.shape;
import static java.lang.Math.*;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public String getShapeName(){
        return "Circle";
    }

    public double getField(){
        return PI*pow(radius,2);
    }
}
