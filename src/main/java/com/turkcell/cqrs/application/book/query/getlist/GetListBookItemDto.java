package com.turkcell.cqrs.application.book.query.getlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListBookItemDto {
    private UUID id;
    private String name;
}
