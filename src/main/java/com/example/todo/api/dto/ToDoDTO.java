package com.example.todo.api.dto;

import lombok.Builder;

@Builder
public record ToDoDTO(Long id, String title) {}
