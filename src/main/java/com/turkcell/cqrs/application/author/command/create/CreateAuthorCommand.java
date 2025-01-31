package com.turkcell.cqrs.application.author.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.cqrs.application.author.mapper.AuthorMapper;
import com.turkcell.cqrs.domain.entity.Author;
import com.turkcell.cqrs.persistance.author.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuthorCommand implements Command<CreatedAuthorResponse> {

    private String firstName;
    private String lastName;

    @Component
    @RequiredArgsConstructor
    public static class CreateAuthorCommandHandler
            implements Command.Handler<CreateAuthorCommand, CreatedAuthorResponse> {

        private final AuthorRepository authorRepository;

        @Override
        public CreatedAuthorResponse handle(CreateAuthorCommand createAuthorCommand) {
            AuthorMapper mapper = AuthorMapper.INSTANCE;
            Author author = mapper.convertCreateAuthorCommandToAuthor(createAuthorCommand);

            authorRepository.save(author);

            return mapper.convertAuthorToCreatedAuthorResponse(author);
        }
    }
}
