package com.turkcell.cqrs.application.book.rules;

import com.turkcell.cqrs.domain.entity.Book;
import com.turkcell.cqrs.persistance.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BookBusinessRules {

    private final BookRepository bookRepository;

    public void bookShouldExistsWithGivenId(UUID id) {
        bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void bookShouldNotBeNull(Book book) {
        if (book == null) {
            throw new RuntimeException("Book not found");
        }
    }
}
