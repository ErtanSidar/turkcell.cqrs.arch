package com.turkcell.cqrs.controllers;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.cqrs.application.book.command.create.CreateBookCommand;
import com.turkcell.cqrs.application.book.command.create.CreatedBookResponse;
import com.turkcell.cqrs.application.book.command.update.UpdateBookCommand;
import com.turkcell.cqrs.application.book.command.update.UpdatedBookResponse;
import com.turkcell.cqrs.application.book.query.getlist.GetListBookItemDto;
import com.turkcell.cqrs.application.book.query.getlist.GetListBookQuery;
import com.turkcell.cqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController extends BaseController {
    public BooksController(Pipeline pipeline) {
        super(pipeline);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<GetListBookItemDto> getAll() {
        GetListBookQuery getListBookQuery = new GetListBookQuery();
        return getListBookQuery.execute(pipeline);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreatedBookResponse create(@RequestBody CreateBookCommand createBookCommand) {
        return createBookCommand.execute(pipeline);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public UpdatedBookResponse update(@RequestBody UpdateBookCommand updateBookCommand) {
        return updateBookCommand.execute(pipeline);
    }
}
