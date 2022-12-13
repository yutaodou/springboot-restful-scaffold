package com.example.todo.domain.event;

public record ToDoCreatedEvent(Long id) implements DomainEvent {}
