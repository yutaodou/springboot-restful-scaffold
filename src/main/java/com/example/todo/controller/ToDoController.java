package com.example.todo.controller;

import com.example.exception.ErrorCode;
import com.example.exception.NotFoundException;
import com.example.todo.api.ToDoApi;
import com.example.todo.api.dto.CreateToDoDTO;
import com.example.todo.api.dto.ToDoDTO;
import com.example.todo.domain.model.ToDo;
import com.example.todo.domain.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class ToDoController implements ToDoApi {

    private final ToDoService toDoService;
    private static final ToDoMapper MAPPER = ToDoMapper.MAPPER;

    @Override
    public List<ToDoDTO> getToDoList() {
        return toDoService.findAll().stream().map(MAPPER::toDTO).collect(toList());
    }

    @Override
    public ToDoDTO getToDo(@PathVariable Long todoId) {
        return MAPPER.toDTO(getOrThrow(todoId));
    }

    private ToDo getOrThrow(Long todoId) {
        return toDoService
                .getById(todoId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.TODO_NOT_FOUND, "ToDo not found: " + todoId));
    }

    @Override
    public ToDoDTO createToDo(@RequestBody CreateToDoDTO request) {
        return MAPPER.toDTO(toDoService.createToDo(request.title()));
    }
}
