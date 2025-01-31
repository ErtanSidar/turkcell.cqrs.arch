package com.turkcell.cqrs.application.student.command.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedStudentResponse {
    private UUID id;

    private String email;

    private String password;

    private String studentNo;
}
