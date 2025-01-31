package com.turkcell.cqrs.application.student.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.cqrs.application.cart.service.CartService;
import com.turkcell.cqrs.application.student.mapper.StudentMapper;
import com.turkcell.cqrs.domain.entity.Cart;
import com.turkcell.cqrs.domain.entity.Student;
import com.turkcell.cqrs.persistance.student.StudentRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
public class CreateStudentCommand implements Command<CreatedStudentResponse> {
    private String email;
    private String password;
    private String studentNo;

    @Component
    @RequiredArgsConstructor
    public static class CreateStudentCommandHandler implements
            Command.Handler<CreateStudentCommand, CreatedStudentResponse> {

        private final StudentRepository studentRepository;
        private final CartService cartService;

        @Override
        public CreatedStudentResponse handle(CreateStudentCommand createStudentCommand) {
            StudentMapper mapper = StudentMapper.INSTANCE;
            Student mappedStudent = mapper.convertCreateStudentCommandToStudent(createStudentCommand);

            Student savedStudent = studentRepository.save(mappedStudent);

            cartService.save(savedStudent.getId());

            return mapper.convertStudentToCreatedStudentResponse(savedStudent);
        }
    }
}
