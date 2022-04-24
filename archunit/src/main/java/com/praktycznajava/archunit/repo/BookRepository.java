package com.praktycznajava.archunit.repo;

import com.praktycznajava.archunit.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookRepository {
    private final static List<Book> books = List.of(
            new Book(1L, "book1"),
            new Book(2L, "book2"),
            new Book(3L, "book3"),
            new Book(4L, "book4"),
            new Book(5L, "book5")
    );

    public List<Book> getBooks()
    {
        return books;
    }
}
