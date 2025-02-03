package com.turkcell.cqrs.application.cartItem.command.create;

import an.awesome.pipelinr.Command;
import com.turkcell.cqrs.application.cart.service.CartService;
import com.turkcell.cqrs.application.cartItem.mapper.CartItemMapper;
import com.turkcell.cqrs.application.student.service.StudentService;
import com.turkcell.cqrs.domain.entity.Cart;
import com.turkcell.cqrs.domain.entity.CartItem;
import com.turkcell.cqrs.domain.entity.Student;
import com.turkcell.cqrs.persistance.cartItem.CartItemRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
public class CreateCartItemCommand implements Command<CreatedCartItemResponse>
{
    private UUID bookId;
    private int quantity;
    private UUID studentId; // JWT ile çalışmalı

    @Component
    @RequiredArgsConstructor
    public static class CreateCartItemCommandHandler
            implements Command.Handler<CreateCartItemCommand,CreatedCartItemResponse>
    {
        private final CartService cartService;
        private final StudentService studentService;
        private final CartItemRepository cartItemRepository;
        private final CartItemMapper cartItemMapper;

        @Override
        public CreatedCartItemResponse handle(CreateCartItemCommand createCartItemCommand) {
            Student student = studentService.findStudentById(createCartItemCommand.getStudentId());
            Cart cart = cartService.getOrCreateCartForStudent(student);

            CartItem cartItem = cart.getCartItems()
                    .stream()
                    .filter((c) -> c.getBook().getId().equals(createCartItemCommand.getBookId()))
                    .findFirst()
                    .orElse(null);

            if(cartItem != null)
            {
                cartItem.setQuantity(cartItem.getQuantity() + createCartItemCommand.getQuantity());
                cartItemRepository.save(cartItem);
            }
            else
            {
                cartItem = cartItemMapper.convertCreateCartItemCommandToCartItem(createCartItemCommand);
                cartItem.setCart(cart);
                cartItemRepository.save(cartItem);
            }

            return cartItemMapper.convertCartItemToCreatedCartItemResponse(cartItem);
        }
    }
}
