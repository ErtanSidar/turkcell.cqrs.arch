package com.turkcell.cqrs.application.orderItem.service;

import com.turkcell.cqrs.domain.entity.CartItem;
import com.turkcell.cqrs.domain.entity.Order;

import java.util.List;

public interface OrderItemService {
    void saveOrderItems(Order savedOrder, List<CartItem> cartItems);
}
