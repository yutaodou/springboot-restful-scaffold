package com.example.todo.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoJpaRepository extends JpaRepository<ToDoDO, Long> {}
