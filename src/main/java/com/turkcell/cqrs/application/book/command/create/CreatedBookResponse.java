package com.turkcell.cqrs.application.book.command.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatedBookResponse {
    private UUID id;
    private String name;
}
