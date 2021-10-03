package com.kodilla.stream.book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;

public class BookTestSuite {

    @Test
    void testGetListUsingFor(){
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublishedAfter2007 = 0;
        for(Book book:books){
            if (book.getYearOfPublication() > 2007){
                numberOfBooksPublishedAfter2007++;
            }
        }
        assertEquals(3,numberOfBooksPublishedAfter2007);
    }

    @Test
    void testGetListUsingStream(){
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        long numberOfBooksPublishedAfter2007 = IntStream.range(0,books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .count();

        assertEquals(3,numberOfBooksPublishedAfter2007);
    }
}
