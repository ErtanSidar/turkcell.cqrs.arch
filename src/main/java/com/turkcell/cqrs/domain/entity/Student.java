package com.turkcell.cqrs.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student extends User {

    @Column(name = "student_no")
    private String studentNo;

    @OneToOne(mappedBy = "student")
    private Cart cart;

    @OneToMany(mappedBy = "student")
    private Set<Order> orders;
}
