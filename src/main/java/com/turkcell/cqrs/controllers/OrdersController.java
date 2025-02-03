package com.turkcell.cqrs.controllers;

import an.awesome.pipelinr.Pipeline;
import com.turkcell.cqrs.application.cartItem.command.create.CreateCartItemCommand;
import com.turkcell.cqrs.application.cartItem.command.create.CreatedCartItemResponse;
import com.turkcell.cqrs.application.order.command.create.CreateOrderCommand;
import com.turkcell.cqrs.application.order.command.create.CreatedOrderResponse;
import com.turkcell.cqrs.core.web.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController extends BaseController {

    public OrdersController(Pipeline pipeline) {
        super(pipeline);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedOrderResponse createCartItem(@RequestBody CreateOrderCommand command) {
        return command.execute(pipeline);
    }
}
