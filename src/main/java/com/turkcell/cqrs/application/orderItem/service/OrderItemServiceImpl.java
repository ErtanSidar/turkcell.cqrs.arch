package com.turkcell.cqrs.application.orderItem.service;

import com.turkcell.cqrs.application.cartItem.service.CartItemService;
import com.turkcell.cqrs.domain.entity.CartItem;
import com.turkcell.cqrs.domain.entity.Order;
import com.turkcell.cqrs.domain.entity.OrderItem;
import com.turkcell.cqrs.persistance.orderItem.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final CartItemService cartItemService;

    @Override
    public void saveOrderItems(Order savedOrder, List<CartItem> cartItems) {
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setBook(cartItem.getBook());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setUnitPrice(cartItem.getBook().getPrice());
            orderItemRepository.save(orderItem);
            cartItemService.delete(cartItem.getId());
        }
    }
}
