package com.example.todo.domain.repository;

import com.example.todo.domain.model.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository {
    Optional<ToDo> getById(Long uuid);

    ToDo save(ToDo toSave);

    List<ToDo> findAll();
}
