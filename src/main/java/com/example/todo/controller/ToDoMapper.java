package com.example.todo.controller;

import com.example.todo.api.dto.ToDoDTO;
import com.example.todo.domain.model.ToDo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface ToDoMapper {
    ToDoMapper MAPPER = Mappers.getMapper(ToDoMapper.class);

    ToDoDTO toDTO(ToDo toDO);
}
