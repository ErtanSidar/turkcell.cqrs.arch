package com.turkcell.cqrs.application.book.command.update;

import an.awesome.pipelinr.Command;
import com.turkcell.cqrs.domain.entity.Book;
import com.turkcell.cqrs.persistance.book.BookRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
public class UpdateBookCommand implements Command<UpdatedBookResponse> {
    private UUID id;
    private String name;

    @Component
    @RequiredArgsConstructor
    public static class UpdateBookCommandHandler
            implements Command.Handler<UpdateBookCommand, UpdatedBookResponse> {
        private final BookRepository bookRepository;

        @Override
        public UpdatedBookResponse handle(UpdateBookCommand command) {
            Book book = bookRepository
                    .findById(command.getId()).orElseThrow(() -> new RuntimeException("Book not found"));

            book.setName(command.getName());
            bookRepository.save(book);

            return new UpdatedBookResponse(book.getId(), book.getName());
        }
    }
}
