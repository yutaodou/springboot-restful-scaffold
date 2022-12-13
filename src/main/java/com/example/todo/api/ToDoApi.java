package com.example.todo.api;

import com.example.todo.api.dto.CreateToDoDTO;
import com.example.todo.api.dto.ToDoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("todos")
public interface ToDoApi {
    @GetMapping
    List<ToDoDTO> getToDoList();

    @GetMapping("/{todoId}")
    ToDoDTO getToDo(@PathVariable Long todoId);

    @PostMapping
    ToDoDTO createToDo(@RequestBody CreateToDoDTO request);
}
