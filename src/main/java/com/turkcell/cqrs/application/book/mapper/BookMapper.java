package com.turkcell.cqrs.application.book.mapper;

import com.turkcell.cqrs.application.book.command.create.CreateBookCommand;
import com.turkcell.cqrs.application.book.command.create.CreatedBookResponse;
import com.turkcell.cqrs.domain.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    // @Mapping(target = "name",source = "title")
    Book convertCreateCommandToBook(CreateBookCommand command);
    CreatedBookResponse convertBookToCreateBookResponse(Book book);
}
