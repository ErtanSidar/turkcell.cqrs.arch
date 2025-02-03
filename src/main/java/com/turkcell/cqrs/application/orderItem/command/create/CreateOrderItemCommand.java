package com.turkcell.cqrs.application.orderItem.command.create;

import an.awesome.pipelinr.Command;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
public class CreateOrderItemCommand implements Command<CreatedOrderItemResponse> {


    @Component
    @RequiredArgsConstructor
    public static class CreateOrderItemCommandHandler implements
            Command.Handler<CreateOrderItemCommand, CreatedOrderItemResponse> {

        @Override
        public CreatedOrderItemResponse handle(CreateOrderItemCommand createOrderItemCommand) {
            return null;
        }
    }
}
