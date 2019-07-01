package com.saha.bookstore.services.SpringDataJPA;

import com.saha.bookstore.model.Book;
import com.saha.bookstore.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceSDJPATest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookServiceSDJPA service;

    Book returnBook;

    @BeforeEach
    void setUp() {
        returnBook = Book.builder().id(1l).build();
    }

    @Test
    void findAll() {
        Set<Book> returnBooksSet = new HashSet<>();
        returnBooksSet.add(Book.builder().id(1l).build());
        returnBooksSet.add(Book.builder().id(2l).build());

        when(bookRepository.findAll()).thenReturn(returnBooksSet);

        Set<Book> books = service.findAll();

        assertNotNull(books);
        assertEquals(2, books.size());
     }

    @Test
    void findById() {
        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(returnBook));

        Book book = service.findById(1L);

        assertNotNull(book);
    }

    @Test
    void save() {
        Book bookToSave = Book.builder().id(1L).build();

        when(bookRepository.save(any())).thenReturn(returnBook);

        Book savedOwner = service.save(bookToSave);

        assertNotNull(savedOwner);

        verify(bookRepository).save(any());

    }

    @Test
    void delete() {

        service.delete(returnBook);

        //default is 1 times
        verify(bookRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(bookRepository).deleteById(anyLong());
    }
}