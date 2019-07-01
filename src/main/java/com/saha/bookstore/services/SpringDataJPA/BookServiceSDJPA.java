package com.saha.bookstore.services.SpringDataJPA;

import com.saha.bookstore.model.Book;
import com.saha.bookstore.repositories.BookRepository;
import com.saha.bookstore.services.BookService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookServiceSDJPA implements BookService {

    private BookRepository bookRepository;

    public BookServiceSDJPA(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Set<Book> findAll() {
        Set<Book> books = new HashSet<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Book findById(Long aLong) {
        return bookRepository.findById(aLong).orElse(null);
    }

    @Override
    public Book save(Book object) {
        return bookRepository.save(object);
    }

    @Override
    public void delete(Book object) {
        bookRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        bookRepository.deleteById(aLong);
    }
}
