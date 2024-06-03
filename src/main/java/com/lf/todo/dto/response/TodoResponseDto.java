package com.lf.todo.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TodoResponseDto {
    private Long id;
    private String username;
    private String detail;
}
