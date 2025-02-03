package com.turkcell.cqrs.persistance.order;

import com.turkcell.cqrs.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

}
