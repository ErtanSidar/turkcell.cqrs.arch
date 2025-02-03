package com.turkcell.cqrs.application.student.service;

import com.turkcell.cqrs.domain.entity.Student;

import java.util.UUID;

public interface StudentService {
    Student findStudentById(UUID id);
}
