package com.turkcell.cqrs.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name="cart_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @UuidGenerator
    private UUID id;

    private int quantity;

    @ManyToOne()
    @JoinColumn(name="cart_id", nullable = false)
    private Cart cart;

    @ManyToOne()
    @JoinColumn(name="book_id",nullable = false)
    private Book book;
}
