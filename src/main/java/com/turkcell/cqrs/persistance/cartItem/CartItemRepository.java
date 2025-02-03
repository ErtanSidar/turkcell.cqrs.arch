package com.turkcell.cqrs.persistance.cartItem;

import com.turkcell.cqrs.domain.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItem, UUID> {
    List<CartItem> findCartItemsByCartId(UUID cartId);
}
