package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public void removeShape(Shape shape){
        shapes.remove(shape);
    }

    public Shape getShape(int shapePos){
        return shapes.get(shapePos);
    }

    public String getShapesNames() {

        String allShapesTemp = "";

        for (Shape shape : shapes) {
            allShapesTemp = shape.getShapeName() + " " + allShapesTemp;
        }

        return allShapesTemp;
    }

    public int size(){
        return shapes.size();
    }
}
