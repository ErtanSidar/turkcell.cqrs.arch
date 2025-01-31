package com.turkcell.cqrs.application.book.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.cqrs.application.author.rules.AuthorBusinessRules;
import com.turkcell.cqrs.application.book.mapper.BookMapper;
import com.turkcell.cqrs.core.pipelines.auth.AuthenticatedRequest;
import com.turkcell.cqrs.domain.entity.Book;
import com.turkcell.cqrs.persistance.book.BookRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
public class CreateBookCommand implements Command<CreatedBookResponse>, AuthenticatedRequest {

    private String name;

    private UUID authorId;

    @Component
    @RequiredArgsConstructor
    public static class CreateBookCommandHandler
            implements Command.Handler<CreateBookCommand, CreatedBookResponse> {

        private final BookRepository bookRepository;
        private final AuthorBusinessRules authorBusinessRules;

        @Override
        public CreatedBookResponse handle(CreateBookCommand createBookCommand) {

            authorBusinessRules.authorWithIdCanNotBeNull(createBookCommand.authorId);

            BookMapper mapper = BookMapper.INSTANCE;
            Book book = mapper.convertCreateBookCommandToBook(createBookCommand);
            bookRepository.save(book);

            return mapper.convertBookToCreateBookResponse(book);
        }
    }
}
