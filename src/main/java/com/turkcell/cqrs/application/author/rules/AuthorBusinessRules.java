package com.turkcell.cqrs.application.author.rules;

import com.turkcell.cqrs.domain.entity.Author;
import com.turkcell.cqrs.persistance.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuthorBusinessRules {

    private final AuthorRepository authorRepository;

    public void authorCanNotBeNull(Author author) {
        if (author == null) {
            throw new RuntimeException("Author can not be null");
        }
    }
    public void authorWithIdCanNotBeNull(UUID authorId) {
        authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author with id " + authorId + " not found"));
    }
}
