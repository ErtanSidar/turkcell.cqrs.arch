package com.turkcell.cqrs.application.author.service;

import com.turkcell.cqrs.domain.entity.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    Author findById(UUID id);
    List<Author> findAll();
    Author save(Author author);
    UUID delete(UUID id);
}
