package com.turkcell.cqrs.application.student.mapper;

import com.turkcell.cqrs.application.student.command.create.CreateStudentCommand;
import com.turkcell.cqrs.application.student.command.create.CreatedStudentResponse;
import com.turkcell.cqrs.domain.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student convertCreateStudentCommandToStudent(CreateStudentCommand createStudentCommand);

    CreatedStudentResponse convertStudentToCreatedStudentResponse(Student student);
}
