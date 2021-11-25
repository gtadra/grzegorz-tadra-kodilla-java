package com.kodilla.testing.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity){
        List<Book> resultList = new ArrayList<>();
        for (int n=1; n <= booksQuantity; n++){
            Book theBook = new Book("Title"+n, "Author"+n, 1970+n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Mock
    private LibraryDatabase libraryDatabaseMock;



    @Test
    void testListBookWithConditionsReturnList(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);                   // [5]
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);    // [6]
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);    // [7]
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);                 // [8]
        resultListOfBooks.add(book1);                                                    // [9]
        resultListOfBooks.add(book2);                                                    // [10]
        resultListOfBooks.add(book3);                                                    // [11]
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
        //Then
        Assertions.assertEquals(4,theListOfBooks.size());
    }

    @Test
    void testListBooksWithConditionMoreThen20(){
    //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);
    //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("AnyTitle");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
    //Then
        Assertions.assertEquals(0,theListOfBooks0.size());
        Assertions.assertEquals(15,theListOfBooks15.size());
        Assertions.assertEquals(0,theListOfBooks40.size());
    }

    @Test
    void testListBooksWithConditionFragmentShorterTehn3(){
    // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
    //When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
    //Then
        Assertions.assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    void testListOfBookInHandOf(){
    //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf1Books = generateListOfNBooks(1);
        List<Book> resultListOf5Books = generateListOfNBooks(5);
        LibraryUser User0 = new LibraryUser("fn0", "ln0","pesel0");
        LibraryUser User1 = new LibraryUser("fn1", "ln1","pesel1");
        LibraryUser User5 = new LibraryUser("fn5", "ln5","pesel5");
        when(libraryDatabaseMock.listBooksInHandsOf(User0)).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksInHandsOf(User1)).thenReturn(resultListOf1Books);
        when(libraryDatabaseMock.listBooksInHandsOf(User5)).thenReturn(resultListOf5Books);
    //When
        List<Book> theListOfBooksUser0 = bookLibrary.listBooksInHandsOf(User0);
        List<Book> theListOfBooksUser1 = bookLibrary.listBooksInHandsOf(User1);
        List<Book> theListOfBooksUser5 = bookLibrary.listBooksInHandsOf(User5);

    //Then
        Assertions.assertEquals(0,theListOfBooksUser0.size());
        Assertions.assertEquals(1,theListOfBooksUser1.size());
        Assertions.assertEquals(5,theListOfBooksUser5.size());
    }
}
