package com.turkcell.cqrs.application.cart.service;

import com.turkcell.cqrs.domain.entity.Cart;
import com.turkcell.cqrs.domain.entity.Student;

import java.util.UUID;

public interface CartService {
    Cart save(UUID studentId);

    Cart createCartForStudent(Student student);

    Cart getOrCreateCartForStudent(Student student);
}
