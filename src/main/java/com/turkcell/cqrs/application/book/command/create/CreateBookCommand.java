package com.turkcell.cqrs.application.book.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.cqrs.application.book.mapper.BookMapper;
import com.turkcell.cqrs.core.pipelines.auth.AuthenticatedRequest;
import com.turkcell.cqrs.domain.entity.Book;
import com.turkcell.cqrs.persistance.book.BookRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
public class CreateBookCommand implements Command<CreatedBookResponse>, AuthenticatedRequest {
    private String name;

    @Component
    @RequiredArgsConstructor
    public static class CreateBookCommandHandler
            implements Command.Handler<CreateBookCommand, CreatedBookResponse> {
        private final BookRepository bookRepository;

        @Override
        public CreatedBookResponse handle(CreateBookCommand createBookCommand) {
            BookMapper mapper = BookMapper.INSTANCE;
            Book book = mapper.convertCreateCommandToBook(createBookCommand);
            bookRepository.save(book);

            return mapper.convertBookToCreateBookResponse(book);
        }
    }
}
