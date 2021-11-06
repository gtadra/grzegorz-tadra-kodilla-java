package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    void testGetBook() {
        //Given
        Library library = new Library("Library 1");
        IntStream.iterate(1,n->n+1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("Title "+n, "Author "+n, LocalDate.now())));
        //shallow copy
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library 2");
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //deep copy
        Library clonedLibrary1 = null;
        try {
            clonedLibrary1 = library.deepCopy();
            clonedLibrary1.setName("Library 3");
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //When
        library.getBooks().add(new Book("T11", "A11", LocalDate.now()));

        //Then
        assertEquals(11,library.books.size());
        assertEquals(11,clonedLibrary.books.size());
        assertEquals(10,clonedLibrary1.books.size());

    }
}
