package com.turkcell.cqrs.persistance.student;

import com.turkcell.cqrs.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
