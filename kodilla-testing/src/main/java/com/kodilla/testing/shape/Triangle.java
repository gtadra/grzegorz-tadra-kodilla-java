package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private double baseLength;
    private double high;

    public Triangle(double baseLength, double high) {
        this.baseLength = baseLength;
        this.high = high;
    }

    public String getShapeName(){
        return "Triangle";
    }

    public double getField(){
        return (baseLength*high)/2;
    }
}
