package com.turkcell.cqrs.persistance.author;

import com.turkcell.cqrs.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
