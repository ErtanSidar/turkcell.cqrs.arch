package com.turkcell.cqrs.application.cartItem.service;

import com.turkcell.cqrs.domain.entity.CartItem;
import com.turkcell.cqrs.persistance.cartItem.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    @Override
    public List<CartItem> findCartItemsByCartId(UUID cartId) {
        return cartItemRepository.findCartItemsByCartId(cartId);
    }

    @Override
    public void delete(UUID id) {
        cartItemRepository.deleteById(id);
    }
}
