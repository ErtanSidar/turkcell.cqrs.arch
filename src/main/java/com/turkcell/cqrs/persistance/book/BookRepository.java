package com.turkcell.cqrs.persistance.book;

import com.turkcell.cqrs.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
