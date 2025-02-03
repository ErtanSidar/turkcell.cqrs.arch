package com.turkcell.cqrs.application.cartItem.mapper;

import com.turkcell.cqrs.application.cartItem.command.create.CreateCartItemCommand;
import com.turkcell.cqrs.application.cartItem.command.create.CreatedCartItemResponse;
import com.turkcell.cqrs.domain.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CartItemMapper {

    @Mapping(target = "book.id", source = "bookId")
    public abstract CartItem convertCreateCartItemCommandToCartItem(CreateCartItemCommand createCartItemCommand);

    public abstract CreatedCartItemResponse convertCartItemToCreatedCartItemResponse(CartItem cartItem);
}
