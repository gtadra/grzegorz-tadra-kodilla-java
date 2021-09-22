package com.kodilla.testing.shape;

public interface Shape {

    default String getShapeName() {
        return null;
    }

    default double getField(){
        return 0;
    }
}
