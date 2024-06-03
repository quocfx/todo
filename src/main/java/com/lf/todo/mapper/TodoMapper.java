package com.lf.todo.mapper;

import com.lf.todo.dto.request.CreateTodoRequestDto;
import com.lf.todo.dto.response.TodoResponseDto;
import com.lf.todo.entity.TodoEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TodoMapper {
    public static TodoResponseDto toResponseDto(TodoEntity entity){
        return TodoResponseDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .detail(entity.getDetail())
                .build();
    }

    public static TodoEntity toEntity(CreateTodoRequestDto requestDto){
        return TodoEntity.builder()
                .username(requestDto.getUsername())
                .detail(requestDto.getDetail())
                .build();
    }
}
