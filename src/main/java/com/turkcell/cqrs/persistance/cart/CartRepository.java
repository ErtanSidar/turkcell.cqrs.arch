package com.turkcell.cqrs.persistance.cart;

import com.turkcell.cqrs.domain.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {
    Optional<Cart> findByStudentId(UUID studentId);
}
