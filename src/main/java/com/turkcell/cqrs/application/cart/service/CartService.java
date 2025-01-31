package com.turkcell.cqrs.application.cart.service;

import com.turkcell.cqrs.domain.entity.Cart;

import java.util.UUID;

public interface CartService {
    Cart save(UUID studentId);
}
