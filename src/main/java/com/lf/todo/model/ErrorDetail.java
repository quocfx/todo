package com.lf.todo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class ErrorDetail {
    private final String field;
    private final String message;

    public ErrorDetail(final String field, final String message) {
        this.field = field;
        this.message= message;
    }
}
