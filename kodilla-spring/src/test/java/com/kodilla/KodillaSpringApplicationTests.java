package com.kodilla;

import com.kodilla.spring.shape.*;
import com.kodilla.spring.shape.Shape;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class KodillaSpringApplicationTests {

//    @Test
//    void testCircleLoadedIntoContainer() {
//        //Given
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Shape shape = context.getBean(Circle.class);
//
//        //When
//        String name = shape.getShapeName();
//
//        //Then
//        assertEquals("This is a circle", name);
//    }
//
//    @Test
//    void testTriangleLoadedIntoContainer() {
//        //Given
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Shape shape = context.getBean(Triangle.class);
//
//        //When
//        String name = shape.getShapeName();
//
//        //Then
//        assertEquals("This is a triangle", name);
//    }
//
//    @Test
//    void testSquareLoadedIntoContainer(){
//        //Given
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Shape shape = context.getBean(Square.class);
//        //When
//        String name = shape.getShapeName();
//        //Then
//        assertEquals("This is a square.", name);
//    }

//    @Test
//    void testCircleLoadedIntoContainer2(){
//        //Given
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Shape shape = (Shape) context.getBean("circle");
//
//        //When
//        String name = shape.getShapeName();
//
//        //Then
//        assertEquals("This is a circle", name);
//    }
//
//    @Test
//    void testTriangleLoadedIntoContainer2(){
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Shape shape = (Shape) context.getBean("triangle");
//
//        //When
//        String name = shape.getShapeName();
//
//        //Then
//        assertEquals("This is a triangle", name);
//    }
//
//    @Test
//    void testSquareLoadedIntoContainer2(){
//        //Given
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Shape shape = (Shape) context.getBean("createSquare");
//        //When
//        String name = shape.getShapeName();
//        //Then
//        assertEquals("This is a square.", name);
//    }
//
//    @Test
//    void testShapeLoadedIntoContainer(){
//        //Given
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Shape shape = (Shape) context.getBean("choseShape");
//        //When
//        String name = shape.getShapeName();
//        //Then
//        System.out.println("Chosen shape: " + name);
//    }

    @Test
    void contextLoads(){

    }

}
