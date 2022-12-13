package com.example.todo.domain.service;

import com.example.todo.domain.event.DomainEventPublisher;
import com.example.todo.domain.event.ToDoCreatedEvent;
import com.example.todo.domain.model.ToDo;
import com.example.todo.domain.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository toDoRepository;
    private final DomainEventPublisher domainEventPublisher;

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    @Transactional
    public ToDo createToDo(String title) {
        ToDo todo = ToDo.builder().title(title).build();
        ToDo saved = toDoRepository.save(todo);

        domainEventPublisher.publish(new ToDoCreatedEvent(todo.getId()));
        return saved;
    }

    public Optional<ToDo> getById(Long todoId) {
        return toDoRepository.getById(todoId);
    }
}
