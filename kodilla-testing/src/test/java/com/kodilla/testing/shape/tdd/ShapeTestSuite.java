package com.kodilla.testing.shape.tdd;

import com.kodilla.testing.shape.*;
import org.junit.jupiter.api.*;
import static java.lang.Math.*;

import static java.lang.Math.pow;

@DisplayName("Tests for task 6.4 - ShapeCollector")
public class ShapeTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("This is beginning of tests.");
    }

    @AfterAll
    public static void AfterAllTests(){
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    void getShapeName(){
        //Given
        Square square = new Square(5);
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(5,5);
        //Then
        Assertions.assertEquals("Square",square.getShapeName());
        Assertions.assertEquals("Circle",circle.getShapeName());
        Assertions.assertEquals("Triangle",triangle.getShapeName());
    }

    @Test
    void getField(){
        //Given
        Square square = new Square(5.0);
        Circle circle = new Circle(5.0);
        Triangle triangle = new Triangle(5.0,5.0);
        //Then
        Assertions.assertEquals(25.0,square.getField());
        Assertions.assertEquals(Math.PI * pow(5.0,2.0), circle.getField());
        Assertions.assertEquals((5.0*5.0)/2.0, triangle.getField());
    }

    @Test
    void addShape(){
        // Given
        ShapeCollector shapes = new ShapeCollector();
        Square square = new Square(5.0);
        Circle circle = new Circle(5.0);
        Triangle triangle = new Triangle(5.0,5.0);
        // When
        shapes.addShape(square);
        shapes.addShape(circle);
        shapes.addShape(triangle);
        //Then
        Assertions.assertEquals(3,shapes.size());

    }

    @Test
    void removeShape(){
        // Given
        ShapeCollector shapes = new ShapeCollector();
        Square square = new Square(5.0);
        Circle circle = new Circle(5.0);
        Triangle triangle = new Triangle(5.0,5.0);
        // When
        shapes.addShape(square);
        shapes.addShape(circle);
        shapes.addShape(triangle);
        shapes.removeShape(circle);
        //Then
        Assertions.assertEquals(2,shapes.size());

    }

    @Test
    void getShape(){
        // Given
        ShapeCollector shapes = new ShapeCollector();
        Square square = new Square(5.0);
        Circle circle = new Circle(5.0);
        Triangle triangle = new Triangle(5.0,5.0);
        // When
        shapes.addShape(square);
        shapes.addShape(circle);
        shapes.addShape(triangle);
        //Then
        Assertions.assertTrue( circle.equals(shapes.getShape(1)));
    }

    @Test
    void getShapeNames(){
        // Given
        ShapeCollector shapes = new ShapeCollector();
        Square square = new Square(5.0);
        Circle circle = new Circle(5.0);
        Triangle triangle = new Triangle(5.0,5.0);
        // When
        shapes.addShape(square);
        shapes.addShape(circle);
        shapes.addShape(triangle);
        String result = "Triangle Circle Square ";
        //Then
        Assertions.assertTrue(result.equals(shapes.getShapesNames()));

    }
}
