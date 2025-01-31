package com.turkcell.cqrs.application.book.service;

import com.turkcell.cqrs.domain.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {
    Book findById(UUID id);
    List<Book> findAll();
    Book save(Book book);
    UUID delete(UUID id);
}
