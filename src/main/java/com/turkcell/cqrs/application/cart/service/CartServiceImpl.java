package com.turkcell.cqrs.application.cart.service;

import com.turkcell.cqrs.domain.entity.Cart;
import com.turkcell.cqrs.domain.entity.Student;
import com.turkcell.cqrs.persistance.cart.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public Cart save(UUID studentId) {
        Cart cart = new Cart();

        Student student = new Student();
        student.setId(studentId);

        cart.setStudent(student);

        cartRepository.save(cart);

        return cart;
    }

    @Override
    public Cart createCartForStudent(Student student) {
        Cart cart = new Cart();
        cart.setStudent(student);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart getOrCreateCartForStudent(Student student) {
        Cart cart = cartRepository.findByStudentId(student.getId()).orElse(null);

        // Her cart kontrolünde yoksa oluşturmuş olacağım.
        if(cart == null)
            cart = this.createCartForStudent(student);

        return cart;
    }
}
