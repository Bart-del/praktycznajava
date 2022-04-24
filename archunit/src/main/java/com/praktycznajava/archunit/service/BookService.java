package com.praktycznajava.archunit.service;

import com.praktycznajava.archunit.entity.Book;
import com.praktycznajava.archunit.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks()
    {
        return bookRepository.getBooks();
    }
}

