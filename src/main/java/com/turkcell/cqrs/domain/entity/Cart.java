package com.turkcell.cqrs.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="carts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart
{
    @Id
    @UuidGenerator
    private UUID id;

    @OneToOne()
    @JoinColumn(name="student_id", unique = true)
    private Student student;

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItems;
}
