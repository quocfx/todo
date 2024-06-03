package com.lf.todo.service;

import com.lf.todo.dto.request.CreateTodoRequestDto;
import com.lf.todo.dto.response.TodoResponseDto;
import com.lf.todo.mapper.TodoMapper;
import com.lf.todo.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(final TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoResponseDto> getTodoByUser(String username) {
        return todoRepository.findByUsername(username).stream().map(TodoMapper::toResponseDto).collect(Collectors.toList());
    }

    public void createTodo(CreateTodoRequestDto requestDto) {
        var entity = TodoMapper.toEntity(requestDto);
        var newTodo = todoRepository.save(entity);
        log.info("Create todo successfully, id: {}, username: {}", newTodo.getId(), newTodo.getUsername());
    }
}