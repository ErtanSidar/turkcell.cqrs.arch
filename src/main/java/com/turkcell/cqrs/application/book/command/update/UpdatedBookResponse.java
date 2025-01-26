package com.turkcell.cqrs.application.book.command.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedBookResponse {
    private UUID id;
    private String name;
}
