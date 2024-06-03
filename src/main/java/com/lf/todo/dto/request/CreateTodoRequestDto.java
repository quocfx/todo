package com.lf.todo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class CreateTodoRequestDto {
    @NotBlank(message = "username is mandatory")
    private String username;

    @NotBlank(message = "detail is mandatory")
    private String detail;
}
