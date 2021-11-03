package com.kodilla.spring.reader;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class ReaderTestSuite {

    @Test
    void testRead(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReadingConfig.class);
        Reader reader = context.getBean(Reader.class);

        //When&Then
        reader.read();
    }

    @Test
    void testConditional(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReadingConfig.class);
        //When
        boolean book2Exist = context.containsBean("book2");
        //Then
        System.out.println("book2 exist in container: " + book2Exist);
    }
}
