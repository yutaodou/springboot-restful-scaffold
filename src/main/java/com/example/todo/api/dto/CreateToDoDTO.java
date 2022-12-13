package com.example.todo.api.dto;

import lombok.Builder;

@Builder
public record CreateToDoDTO(String title) {}
