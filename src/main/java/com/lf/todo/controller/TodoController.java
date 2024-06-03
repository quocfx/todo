package com.lf.todo.controller;

import com.lf.todo.dto.request.CreateTodoRequestDto;
import com.lf.todo.dto.response.TodoResponseDto;
import com.lf.todo.entity.TodoEntity;
import com.lf.todo.service.TodoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("lf/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity<List<TodoResponseDto>> getTodoByUser(@PathVariable("username") String username) {
        return new ResponseEntity<>(todoService.getTodoByUser(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createTodo(@Valid @RequestBody final CreateTodoRequestDto createTodoRequestDto) {
        todoService.createTodo(createTodoRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
