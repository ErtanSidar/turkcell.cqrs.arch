package com.turkcell.cqrs.application.book.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.cqrs.domain.entity.Book;
import com.turkcell.cqrs.persistance.book.BookRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
public class CreateBookCommand implements Command<CreatedBookResponse> {
    private String name;

    @Component
    @RequiredArgsConstructor
    public static class CreateBookCommandHandler
            implements Command.Handler<CreateBookCommand, CreatedBookResponse> {
        private final BookRepository bookRepository;

        @Override
        public CreatedBookResponse handle(CreateBookCommand createBookCommand) {
            Book book = new Book();
            book.setName(createBookCommand.getName());
            bookRepository.save(book);

            return new CreatedBookResponse(book.getId(), book.getName());
        }
    }
}
