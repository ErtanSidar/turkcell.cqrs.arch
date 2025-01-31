package com.turkcell.cqrs.application.author.mapper;

import com.turkcell.cqrs.application.author.command.create.CreateAuthorCommand;
import com.turkcell.cqrs.application.author.command.create.CreatedAuthorResponse;
import com.turkcell.cqrs.domain.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {
    
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
    
    Author convertCreateAuthorCommandToAuthor(CreateAuthorCommand createAuthorCommand);

    CreatedAuthorResponse convertAuthorToCreatedAuthorResponse(Author author);
}
