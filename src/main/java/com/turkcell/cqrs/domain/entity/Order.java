package com.turkcell.cqrs.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne()
    @JoinColumn(name="student_id", unique = true)
    private Student student;

    @Column(name="order_date")
    private LocalDate orderDate;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;
}
