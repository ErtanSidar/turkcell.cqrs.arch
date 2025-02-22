package com.turkcell.cqrs.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    @Id
    @UuidGenerator
    private UUID id;

    private String name;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book")
    private Set<CartItem> cartItems;
}
