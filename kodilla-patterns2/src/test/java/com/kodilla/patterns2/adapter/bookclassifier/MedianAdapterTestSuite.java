package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest(){
        //Given
        Book book1 = new Book("Author 1", "Title 1", 1998, "ABC");
        Book book2 = new Book("Author 2", "Title 2", 1999, "ABC");
        Book book3 = new Book("Author 3", "Title 3", 2010, "ABC");
        Book book4 = new Book("Author 4", "Title 4", 2020, "ABC");
        Book book5 = new Book("Author 5", "Title 5", 2021, "ABC");
        Set<Book> booksSet = new HashSet<>();
        booksSet.add(book1);
        booksSet.add(book2);
        booksSet.add(book3);
        booksSet.add(book4);
        booksSet.add(book5);
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int result = medianAdapter.publicationYearMedian(booksSet);
        System.out.println(result);
        //Then
        assertEquals(2010, result);

    }
}
