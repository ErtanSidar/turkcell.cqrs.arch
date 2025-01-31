package com.turkcell.cqrs.core.exception.type;

import lombok.Data;

import java.util.List;

@Data
public class ValidationException extends RuntimeException {
    private List<String> errors;
    public ValidationException(List<String> errors) {
        this.errors = errors;
    }
}
