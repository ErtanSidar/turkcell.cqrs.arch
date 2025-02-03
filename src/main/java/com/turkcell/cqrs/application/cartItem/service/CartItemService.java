package com.turkcell.cqrs.application.cartItem.service;

import com.turkcell.cqrs.domain.entity.CartItem;

import java.util.List;
import java.util.UUID;

public interface CartItemService {
    List<CartItem> findCartItemsByCartId(UUID cartId);

    void delete(UUID id);
}
