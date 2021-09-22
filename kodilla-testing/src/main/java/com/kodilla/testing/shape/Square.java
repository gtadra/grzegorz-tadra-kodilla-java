package com.kodilla.testing.shape;
import static java.lang.Math.*;

public class Square implements Shape{
    private double lengthSideSquere;

    public Square(double lengthSideSquere) {
        this.lengthSideSquere = lengthSideSquere;
    }

    public double getLengthSideSquere() {
        return lengthSideSquere;
    }

    public String getShapeName(){
        return "Square";
    }

    public double getField(){
        return pow(lengthSideSquere,2);
    }
}
