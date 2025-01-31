package com.turkcell.cqrs.application.author.command.create;

import lombok.Data;

import java.util.UUID;

@Data
public class CreatedAuthorResponse {
    private UUID id;
    private String firstName;
    private String lastName;
}
