package com.turkcell.cqrs.application.order.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.cqrs.application.cartItem.service.CartItemService;
import com.turkcell.cqrs.application.orderItem.service.OrderItemService;
import com.turkcell.cqrs.domain.entity.CartItem;
import com.turkcell.cqrs.domain.entity.Order;
import com.turkcell.cqrs.domain.entity.Student;
import com.turkcell.cqrs.persistance.order.OrderRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class CreateOrderCommand implements Command<CreatedOrderResponse> {

    private final UUID studentId;
    private final UUID cartId;

    @Component
    @RequiredArgsConstructor
    public static class CreateOrderCommandHandler implements
            Command.Handler<CreateOrderCommand, CreatedOrderResponse> {

        private final OrderRepository orderRepository;
        private final OrderItemService orderItemService;
        private final CartItemService cartItemService;

        @Override
        public CreatedOrderResponse handle(CreateOrderCommand createOrderCommand) {

            Order order = new Order();

            Student student = new Student();
            student.setId(createOrderCommand.studentId);

            order.setStudent(student);
            order.setOrderDate(LocalDate.now());
            Order savedOrder = orderRepository.save(order);

            List<CartItem> cartItems = cartItemService.findCartItemsByCartId(createOrderCommand.cartId);
            orderItemService.saveOrderItems(savedOrder, cartItems);

            return null;
        }
    }
}
