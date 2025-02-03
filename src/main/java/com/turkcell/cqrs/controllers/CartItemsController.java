package com.turkcell.cqrs.controllers;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.cqrs.application.cartItem.command.create.CreateCartItemCommand;
import com.turkcell.cqrs.application.cartItem.command.create.CreatedCartItemResponse;
import com.turkcell.cqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart-items")
public class CartItemsController extends BaseController {
    public CartItemsController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCartItemResponse createCartItem(@RequestBody CreateCartItemCommand command) {
        return command.execute(pipeline);
    }
}
