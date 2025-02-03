package com.turkcell.cqrs.persistance.orderItem;

import com.turkcell.cqrs.domain.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
}
