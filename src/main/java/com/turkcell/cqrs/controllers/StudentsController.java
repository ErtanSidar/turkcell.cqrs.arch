package com.turkcell.cqrs.controllers;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.cqrs.application.student.command.create.CreateStudentCommand;
import com.turkcell.cqrs.application.student.command.create.CreatedStudentResponse;
import com.turkcell.cqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentsController extends BaseController {

    public StudentsController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreatedStudentResponse create(@RequestBody CreateStudentCommand createStudentCommand) {
        return createStudentCommand.execute(pipeline);
    }
}
